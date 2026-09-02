package api.core.streamx.modules.videos.dto.response;

import api.core.streamx.modules.videos.enums.Visibility;

import java.time.LocalDateTime;

public record PlaylistResponse(Long id,
                               String playListName,
                               Visibility visibility,
                               LocalDateTime createdAt) {
}
