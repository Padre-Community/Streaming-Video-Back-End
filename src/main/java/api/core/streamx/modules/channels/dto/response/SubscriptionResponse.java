package api.core.streamx.modules.channels.dto.response;

import java.time.LocalDateTime;
import api.core.streamx.modules.users.dto.response.UsersResponse;

public record SubscriptionResponse(
    Long id,
    Boolean notifyEnabled,
    LocalDateTime subscribedAt,
    UsersResponse subscriber,
    ChannelResponse channel
){
}
