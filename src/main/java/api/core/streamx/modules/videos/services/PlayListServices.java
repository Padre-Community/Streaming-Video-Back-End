package api.core.streamx.modules.videos.services;

import api.core.streamx.modules.exception.videos.PlaylistNotFoundException;
import api.core.streamx.modules.videos.dto.response.PlaylistResponse;
import api.core.streamx.modules.videos.model.PlayList;
import api.core.streamx.modules.videos.repository.PlayListRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayListServices {
    PlayListRepository playListRepository;

    public PlayListServices(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }


    public PlaylistResponse atualizarNome(Long id, String nome) {
        PlayList playList = playListRepository.findById(id)
                .orElseThrow(() -> new PlaylistNotFoundException("Playlist not found"));


        playList.setPlayListName(nome);
        playListRepository.save(playList);

        return new PlaylistResponse(
                playList.getId(),
                playList.getPlayListName(),
                playList.getVisibility(),
                playList.getCreatedAt()
        );
    }
}
