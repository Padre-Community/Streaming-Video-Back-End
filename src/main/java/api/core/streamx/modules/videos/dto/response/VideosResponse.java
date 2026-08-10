package api.core.streamx.modules.videos.dto.response;

import api.core.streamx.modules.channels.dto.response.ChannelResponseSimple;
import api.core.streamx.modules.videos.enums.StatusVideo;
import api.core.streamx.modules.videos.enums.Visibility;

import java.time.LocalDateTime;


public record VideosResponse(

                Long id,
                String title,
                String description,
                String thumbnailUrl,
                String url,
                Visibility visibility,
                StatusVideo statusVideo,
                Integer durationSeconds,
                Long viewCount,
                Integer likeCount,
                String tags,
                String chapters,
                LocalDateTime publishedAt,
                Boolean liked,
                CategoryResponse category,
                ChannelResponseSimple channel,
                PlaylistResponse playlist
) {
}
