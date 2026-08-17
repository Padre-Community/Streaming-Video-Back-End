package api.core.streamx.modules.playlist.services;

import api.core.streamx.modules.playlist.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlayListServices {

    private final PlayListRepository repository;
}
