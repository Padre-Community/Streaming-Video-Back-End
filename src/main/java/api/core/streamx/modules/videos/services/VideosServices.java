package api.core.streamx.modules.videos.services;

import api.core.streamx.modules.videos.repository.VideosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VideosServices {

    private final VideosRepository videosRepository;
}
