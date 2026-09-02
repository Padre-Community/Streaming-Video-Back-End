package api.core.streamx.modules.videos.repository;

import api.core.streamx.modules.videos.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Long> {


}