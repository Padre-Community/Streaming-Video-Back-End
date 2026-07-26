package api.core.stream_video_backend.modules.videos.repository;

import api.core.stream_video_backend.modules.videos.model.PlayListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListItemRepository extends JpaRepository<PlayListItem, Long> {
}
