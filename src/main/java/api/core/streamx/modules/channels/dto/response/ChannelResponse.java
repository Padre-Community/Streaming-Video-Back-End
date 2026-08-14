package api.core.streamx.modules.channels.dto.response;

import api.core.streamx.modules.users.dto.response.UsersResponse;

import java.time.LocalDateTime;

public record ChannelResponse(
        Long id,
        String name,
        String slug,
        String description,
        String bannerUrl,
        Integer subscriberCount,
        Boolean isMonetized,
        LocalDateTime createdAt,
        UsersResponse owner
        ) {
}
