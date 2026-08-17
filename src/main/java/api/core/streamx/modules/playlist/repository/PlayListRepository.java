package api.core.streamx.modules.playlist.repository;

import api.core.streamx.modules.playlist.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Long> {

}