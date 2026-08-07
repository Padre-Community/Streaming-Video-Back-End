package api.core.streamx.modules.videos.dto.request;

import api.core.streamx.modules.videos.enums.Visibility;

public record PlaylistRequestDTO(String playListName, Visibility visibility) {
}
