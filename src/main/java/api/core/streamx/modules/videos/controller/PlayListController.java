package api.core.streamx.modules.videos.controller;

import api.core.streamx.modules.videos.dto.request.PlaylistRequest;
import api.core.streamx.modules.videos.dto.response.PlaylistResponse;
import api.core.streamx.modules.videos.services.PlayListServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlayListController {

    private final PlayListServices playListServices;
    public PlayListController(PlayListServices playListServices) {
        this.playListServices = playListServices;
    }


    @PutMapping("/update")
    public ResponseEntity<PlaylistResponse> atualizarPlaylist(
            @RequestParam Long id,
            @RequestBody PlaylistRequest request) {

        PlaylistResponse playlistResponse = playListServices.atualizarNome(id, request.playListName()) ;

        return ResponseEntity.ok(playlistResponse);
    }

}