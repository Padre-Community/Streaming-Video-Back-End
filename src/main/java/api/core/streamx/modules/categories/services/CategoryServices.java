package api.core.streamx.modules.categories.services;

import api.core.streamx.modules.playlist.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServices {

    private final PlayListRepository repository;
}
