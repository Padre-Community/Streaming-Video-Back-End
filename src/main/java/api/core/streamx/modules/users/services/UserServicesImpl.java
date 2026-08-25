package api.core.streamx.modules.users.services;

import api.core.streamx.modules.exception.videos.BusinessException;
import api.core.streamx.modules.users.dto.request.UsersRequest;
import api.core.streamx.modules.users.dto.response.FollowerResponse;
import api.core.streamx.modules.users.dto.response.ListUserFollowersResponse;
import api.core.streamx.modules.users.dto.response.UserFollowersResponse;
import api.core.streamx.modules.users.dto.response.UsersResponse;
import api.core.streamx.modules.users.enums.UserPlan;
import api.core.streamx.modules.users.model.Follower;
import api.core.streamx.modules.users.model.Users;
import api.core.streamx.modules.users.repository.FollowersRepository;
import api.core.streamx.modules.users.repository.UsersRepository;
import api.core.streamx.modules.users.utils.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UsersServices {

    private final List<UserValidation> userValidations;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final FollowersRepository followersRepository;

    public UsersResponse registerUser(UsersRequest request) {

        userValidations.forEach(validation -> validation.execute(request));

        Users users = Users.builder()
                           .name(request.name())
                           .email(request.email())
                           .password(passwordEncoder.encode(request.password()))
                           .createdAt(LocalDateTime.now())
                           .updatedAt(LocalDateTime.now())
                           .status(true)
                           .build();

        Users save = usersRepository.save(users);

        return new UsersResponse(save.getName(), save.getEmail());
    }

    public UserFollowersResponse findFollowers(Long userID) {

        Users user = usersRepository.findById(userID)
                                    .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        List<Users> followers = followersRepository.findFollowers(userID);

        List<FollowerResponse> response = followers.stream()
                                                   .map(f -> new FollowerResponse(f.getName()))
                                                   .toList();

        return new UserFollowersResponse(user.getName(), response);
    }

    @Override
    public UsersResponse updateUser(Long userID, UsersRequest request, UserPlan plan) {
        return null;
    }

    @Override
    public ListUserFollowersResponse follow(Long userID, Long followerID) {

        Users user = usersRepository.findById(userID)
                                    .orElseThrow(() -> new BusinessException("USUÁRIO NÃO ENCONTRADO"));

        Users follower = usersRepository.findById(followerID)
                                        .orElseThrow(() -> new BusinessException("SEGUIDOR NÃO ENCONTRADO"));

        if (Objects.equals(user.getId(), follower.getId())){
            throw new BusinessException("VOCÊ NÂO PODE SEGUIR A SI MESMO");
        }

        if (user.getStatus() == false || follower.getStatus() == false){
            throw new BusinessException("USUÁRIO OU SEGUIDOR INATIVO");
        }

        boolean alreadyFollowMe = followersRepository.existsByUserIdAndFollowerId(user.getId(), follower.getId());

        if (alreadyFollowMe) {
            throw new BusinessException("VOCÊ JÁ SEGUE A ESTE USUÁRIO");
        }

        Follower newFollow = Follower.builder()
                                     .followerId(follower.getId())
                                     .nameFollower(follower.getName())
                                     .followers(user)
                                     .createdAt(LocalDateTime.now())
                                     .build();

        Follower f = followersRepository.save(newFollow);

        return new ListUserFollowersResponse(user.getName(), f.getFollowers().getFollowers());
    }

    @Override
    public ListUserFollowersResponse unfollow(Long userID, Long followerID) {
        return null;
    }

    @Override
    public List<ListUserFollowersResponse> viewUserFollowers(Long userID) {
        return usersRepository.findById(userID)
                              .stream()
                              .map((u) -> new ListUserFollowersResponse(u.getName(), u.getFollowers().stream().sorted(Comparator.comparing(Follower::getNameFollower)).toList()))
                              .toList();
    }

    @Override
    public UsersResponse findUsers(UsersRequest request) {
        return null;
    }

    @Override
    public UsersResponse findUsersByEmail(String email) {
        return null;
    }

    @Override
    public List<UsersResponse> searchUsers(UsersRequest request) {
        return List.of();
    }
}
