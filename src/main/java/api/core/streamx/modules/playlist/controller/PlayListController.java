package api.core.streamx.modules.playlist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/playlist")
public class PlayListController {

    public ResponseEntity<?> createPlayList() {

        // Implementation Caller here
        return null;
    }

    public ResponseEntity<?> fetchPlaylistByName(String playlistName) {

        // Implementation Caller here
        // { "userName": "User Name", "playlistName": "Playlist Name", "videos": ["video1", "video2", "video3"] }
        return null;
    }

    public ResponseEntity<?> fetchPlaylistByUser(String userName) {

        // Implementation Caller here
        // { "userName": "User Name", "playlistName": "Playlist Name", "videos": ["video1", "video2", "video3"] }
        return null;
    }
}
