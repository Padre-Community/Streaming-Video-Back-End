package api.core.streamx.modules.users.dto.response;

import java.util.List;

public record ListUserFollowersResponse(String name,
                                        List<FollowerResponse> followers) {}
