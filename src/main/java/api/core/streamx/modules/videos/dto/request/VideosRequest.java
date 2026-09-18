package api.core.streamx.modules.videos.dto.request;


import api.core.streamx.modules.videos.enums.Visibility;

public record VideosRequest(String title,
                            String description,
                            String thumbnailUrl,
                            Visibility visibility,
                            String tags,
                            Long category_id,
                            Long playlist_id
) {
}
