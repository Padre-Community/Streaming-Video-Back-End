package api.core.streamx.modules.playlist.services;

import api.core.streamx.modules.playlist.dto.response.PlayListResponse;
import api.core.streamx.modules.playlist.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlayListServices {

    PlayListResponse createPlayListName(Long userID, String playListName);

    PlayListResponse updatePlayListName(Long userID, String playListName);

    List<PlayListResponse> findNamePlayList(String fetchPlayListName, Integer page, Integer size);
}
