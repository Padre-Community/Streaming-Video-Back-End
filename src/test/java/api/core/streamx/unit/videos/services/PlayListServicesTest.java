package api.core.streamx.unit.videos.services;

import api.core.streamx.modules.videos.model.PlayList;
import api.core.streamx.modules.videos.repository.PlayListRepository;
import api.core.streamx.modules.videos.services.PlayListServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayListServicesTest {

    @Mock
    private PlayListRepository repository;

    @InjectMocks
    private PlayListServices service;

    @Test
    void deveAtualizarNomeDaPlaylist() {
        PlayList playlist = new PlayList();
        playlist.setId(10L);
        playlist.setPlayListName("Favoritos antigos");

        when(repository.findById(10L)).thenReturn(Optional.of(playlist));

        service.atualizarNome(10L, "Favoritos 2026");

        assertEquals("Favoritos 2026", playlist.getPlayListName());
        verify(repository).save(playlist);
    }
}