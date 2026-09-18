package api.core.streamx.modules.users.dto.response;

import api.core.streamx.modules.users.model.Follower;

import java.util.List;

public record ListUserFollowersResponse(String name,
                                        List<Follower> followers) {}
