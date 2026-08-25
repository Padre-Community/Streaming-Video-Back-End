package api.core.streamx.modules.videos.services;

import api.core.streamx.modules.exception.videos.BusinessException;
import api.core.streamx.modules.videos.dto.response.VideosResponse;

import java.util.List;

public interface VideosServices {

    VideosResponse createVideo(Long userId, Long categoryId) throws BusinessException;

    VideosResponse updateVideo(Long idVideo, Long userId, Long categoryId) throws BusinessException;

    List<VideosResponse> findVideosByCategory(Long categoryId) throws BusinessException;

    List<VideosResponse> findVideosByCategory(String categoryName) throws BusinessException;
}
