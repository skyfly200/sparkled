package io.sparkled.persistence.stage.impl.query;

import io.sparkled.model.entity.Stage;
import io.sparkled.model.entity.StageProp;
import io.sparkled.persistence.PersistenceQuery;
import io.sparkled.persistence.song.impl.query.DeleteRenderedStagePropsQuery;
import io.sparkled.persistence.song.impl.query.DeleteSongQuery;
import io.sparkled.persistence.song.impl.query.GetSongsByStageIdQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;
import java.util.logging.Logger;

public class DeleteStageQuery implements PersistenceQuery<Integer> {

    private static final Logger logger = Logger.getLogger(DeleteRenderedStagePropsQuery.class.getName());

    private final int stageId;

    public DeleteStageQuery(int stageId) {
        this.stageId = stageId;
    }

    @Override
    public Integer perform(EntityManager entityManager) {
        removeSongs(entityManager);
        removeStageProps(entityManager);
        removeStage(entityManager);

        return stageId;
    }

    private void removeSongs(EntityManager entityManager) {
        new GetSongsByStageIdQuery(stageId).perform(entityManager).forEach(song -> {
            new DeleteSongQuery(song.getId()).perform(entityManager);
        });
    }

    private void removeStageProps(EntityManager entityManager) {
        String className = StageProp.class.getSimpleName();
        Query query = entityManager.createQuery("delete from " + className + " where stageId = :id");
        query.setParameter("id", stageId);

        int deleted = query.executeUpdate();
        logger.info("Deleted " + deleted + " " + className + " record(s) for stage " + stageId);
    }

    private void removeStage(EntityManager entityManager) {
        Optional<Stage> stage = new GetStageByIdQuery(stageId).perform(entityManager);
        stage.ifPresent(entityManager::remove);
    }
}
