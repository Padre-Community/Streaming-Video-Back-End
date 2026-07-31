package api.core.stream_video_backend.modules.videos.controller;

import api.core.stream_video_backend.modules.videos.repository.VideosRepository;
import api.core.stream_video_backend.modules.videos.services.VideosServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "")
public class VideosController {

    private final VideosServices videosServices;

    @GetMapping
    public ResponseEntity<?> videos() {
        return null;
    }

}

