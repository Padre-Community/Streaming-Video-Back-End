package api.core.streamx.modules.videos.repository;

import api.core.streamx.modules.videos.model.PlayListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListItemRepository extends JpaRepository<PlayListItem, Long> {
}
