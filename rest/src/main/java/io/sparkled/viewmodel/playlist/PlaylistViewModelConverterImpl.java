package io.sparkled.viewmodel.playlist;

import io.sparkled.model.entity.Playlist;
import io.sparkled.persistence.playlist.PlaylistPersistenceService;
import io.sparkled.viewmodel.exception.ViewModelConversionException;

import javax.inject.Inject;

public class PlaylistViewModelConverterImpl implements PlaylistViewModelConverter {

    private PlaylistPersistenceService playlistPersistenceService;

    @Inject
    public PlaylistViewModelConverterImpl(PlaylistPersistenceService playlistPersistenceService) {
        this.playlistPersistenceService = playlistPersistenceService;
    }

    @Override
    public PlaylistViewModel toViewModel(Playlist model) {
        return new PlaylistViewModel()
                .setId(model.getId())
                .setName(model.getName());
    }

    @Override
    public Playlist fromViewModel(PlaylistViewModel viewModel) {
        Integer playlistId = viewModel.getId();
        Playlist model = getPlaylist(playlistId);
        return model.setName(viewModel.getName());
    }

    private Playlist getPlaylist(Integer playlistId) {
        if (playlistId == null) {
            return new Playlist();
        } else {
            return playlistPersistenceService.getPlaylistById(playlistId)
                    .orElseThrow(() -> new ViewModelConversionException("Playlist with ID of '" + playlistId + "' not found."));
        }
    }
}