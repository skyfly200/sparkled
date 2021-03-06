package io.sparkled.rest.service.playlist

import io.sparkled.viewmodel.playlist.PlaylistViewModel
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/playlists")
class PlaylistRestService
@Inject constructor(private val handler: PlaylistRestServiceHandler) {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createPlaylist(playlistViewModel: PlaylistViewModel): Response {
        return handler.createPlaylist(playlistViewModel)
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllPlaylists(): Response {
        return handler.getAllPlaylists()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPlaylist(@PathParam("id") playlistId: Int): Response {
        return handler.getPlaylist(playlistId)
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updatePlaylist(@PathParam("id") id: Int, playlistViewModel: PlaylistViewModel): Response {
        return handler.updatePlaylist(id, playlistViewModel)
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun deletePlaylist(@PathParam("id") id: Int): Response {
        return handler.deletePlaylist(id)
    }
}