package api.core.streamx.modules.playlist.services;

import api.core.streamx.modules.playlist.dto.response.PlayListResponse;
import api.core.streamx.modules.playlist.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlayListServicesImpl implements PlayListServices {

    private final PlayListRepository playListRepository;

    @Override
    public PlayListResponse createPlayListName(Long userID, String playListName) {
        return null;
    }

    @Override
    public PlayListResponse updatePlayListName(Long userID, String playListName) {
        return null;
    }

    @Override
    public List<PlayListResponse> findNamePlayList(String fetchPlayListName, Integer page, Integer size) {
        return List.of();
    }
}
