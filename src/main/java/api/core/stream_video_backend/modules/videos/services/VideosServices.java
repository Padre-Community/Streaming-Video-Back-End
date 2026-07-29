package api.core.stream_video_backend.modules.videos.services;

import api.core.stream_video_backend.modules.videos.repository.VideosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VideosServices {

    private final VideosRepository videosRepository;
}
