package api.core.streamx.modules.videos.controller;

import api.core.streamx.modules.videos.dto.response.VideosResponse;
import api.core.streamx.modules.videos.services.VideosServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/video")
@RequiredArgsConstructor
public class VideosController {

    private final VideosServices videosServices;

    @GetMapping("/category")
    public ResponseEntity<List<VideosResponse>> listVideosByCategory(@RequestParam(name = "category_id") Long categoryId) {
        return ResponseEntity.ok(videosServices.listVideosByCategory(categoryId));
    }

}

