package api.core.streamx.modules.videos.dto.request;


import api.core.streamx.modules.videos.enums.Visibility;
import api.core.streamx.modules.videos.model.Category;
import api.core.streamx.modules.videos.model.PlayList;

public record VideosRequestDTO(String title,
                               String description,
                               String thumbnailUrl,
                               Visibility visibility,
                               String tags,
                               Long category_id,
                               Long playlist_id
) {
}
