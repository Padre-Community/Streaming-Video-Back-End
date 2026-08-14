package api.core.streamx.modules.videos.services;

import api.core.streamx.modules.videos.dto.response.VideosResponse;
import api.core.streamx.modules.videos.model.Video;
import api.core.streamx.modules.videos.repository.VideosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideosServices {

    private final VideosRepository videosRepository;
    public List<VideosResponse> listVideosByCategory(Long categoryId) {
        List<Video> videos = videosRepository.findByCategoryId(categoryId);
        return  videos.stream()

            .map(video -> new VideosResponse(
                    video.getId(),
                    video.getChannelName(),
                    video.getTitle(),
                    video.getThumbnailUrl(),
                    video.getDurationSeconds(),
                    video.getViewCount()
            ))
            .toList();
    }

}
