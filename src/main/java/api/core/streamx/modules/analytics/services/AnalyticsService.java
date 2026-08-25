package api.core.streamx.modules.analytics.services;

import api.core.streamx.modules.analytics.dto.response.AnalyticsResponse;
import api.core.streamx.modules.exception.videos.BusinessException;
import api.core.streamx.modules.users.dto.response.FollowerResponse;
import api.core.streamx.modules.users.dto.response.ListUserFollowersResponse;
import api.core.streamx.modules.users.dto.response.UserFollowersResponse;
import api.core.streamx.modules.users.model.Users;
import api.core.streamx.modules.users.repository.UsersRepository;
import api.core.streamx.modules.users.services.UsersServices;
import api.core.streamx.modules.videos.repository.CommentsRepository;
import api.core.streamx.modules.videos.repository.VideosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnalyticsService {

    private final UsersServices usersServices;

    private final UsersRepository usersRepository;

    private final VideosRepository videosRepository;

    private final CommentsRepository commentsRepository;

    public AnalyticsResponse numberOfCommentsFromUser(Long userID) {

        Users name = usersRepository.findById(userID)
                                    .orElseThrow(() -> new BusinessException("USUÁRIO NÃO ENCONTRADO"));

        int numberOfCommentsFromUser = commentsRepository.findById(userID)
                                                         .stream()
                                                         .map((c) -> c.getUsers().getComments())
                                                         .mapToInt(List::size)
                                                         .sum();

        int numberOfVideosPostedByUser = videosRepository.findById(userID)
                                                         .stream()
                                                         .map((v) -> v.getPlayList().getPlayListVideos())
                                                         .mapToInt(List::size)
                                                         .sum();

        int numberOfFollowers = usersServices.viewUserFollowers(userID)
                                             .stream()
                                             .map(ListUserFollowersResponse::followers)
                                             .mapToInt(List::size)
                                             .sum();

        int countLikes = videosRepository.countLikeVideos();

        int size = usersRepository.findAll().size();

        Double average = (double) ((numberOfFollowers * 100) / size);

        return new AnalyticsResponse(name.getName(),
                                     numberOfCommentsFromUser,
                                     numberOfVideosPostedByUser,
                                     countLikes,
                                     numberOfFollowers,
                                     average);
    }
}
