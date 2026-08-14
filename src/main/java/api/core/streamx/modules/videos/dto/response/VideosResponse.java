package api.core.streamx.modules.videos.dto.response;

public record VideosResponse(
        Long id,
        String channelName,
        String title,
        String thumbnailUrl,
        Integer durationSeconds,
        Long viewCount
) {}
