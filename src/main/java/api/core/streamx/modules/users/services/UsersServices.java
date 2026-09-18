package api.core.streamx.modules.users.services;

import api.core.streamx.modules.users.dto.request.UsersRequest;
import api.core.streamx.modules.users.dto.response.ListUserFollowersResponse;
import api.core.streamx.modules.users.dto.response.UserFollowersResponse;
import api.core.streamx.modules.users.dto.response.UsersResponse;
import api.core.streamx.modules.users.enums.UserPlan;

import java.util.List;

public interface UsersServices {

    UsersResponse registerUser(UsersRequest request);

    UserFollowersResponse findFollowers(Long userID);

    UsersResponse updateUser(Long userID, UsersRequest request, UserPlan plan);

    ListUserFollowersResponse follow(Long userID, Long followerID);

    ListUserFollowersResponse unfollow(Long userID, Long followerID);

    List<ListUserFollowersResponse> viewUserFollowers(Long userID);

    UsersResponse findUsers(UsersRequest request);

    UsersResponse findUsersByEmail(String email);

    List<UsersResponse> searchUsers(UsersRequest request);
}
