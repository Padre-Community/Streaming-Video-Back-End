package api.core.streamx.modules.videos.services;

import api.core.streamx.modules.exception.videos.BusinessException;
import api.core.streamx.modules.videos.dto.response.VideosResponse;
import api.core.streamx.modules.videos.model.Video;
import api.core.streamx.modules.videos.repository.VideosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoServicesImpl implements VideosServices {

    private final VideosRepository videosRepository;

    @Override
    public VideosResponse createVideo(Long userId, Long categoryId) throws BusinessException {
        return null;
    }

    @Override
    public VideosResponse updateVideo(Long idVideo, Long userId, Long categoryId) throws BusinessException {
        return null;
    }

    @Override
    public List<VideosResponse> findVideosByCategory(Long categoryId) throws BusinessException {
        List<Video> videos = videosRepository.findByCategoryId(categoryId);
        return videos.stream()
                     .map(video -> new VideosResponse(
                                video.getChannelName(),
                                video.getTitle(),
                                video.getThumbnailUrl(),
                                video.getDurationSeconds(),
                                video.getViewCount()))
                     .toList();
    }

    @Override
    public List<VideosResponse> findVideosByCategory(String categoryName) throws BusinessException {
        return List.of();
    }
}
