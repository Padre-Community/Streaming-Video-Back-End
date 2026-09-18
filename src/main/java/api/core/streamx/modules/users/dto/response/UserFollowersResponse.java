package api.core.streamx.modules.users.dto.response;

import java.util.List;

public record UserFollowersResponse(String userName,
                                    List<FollowerResponse> followers) {}
