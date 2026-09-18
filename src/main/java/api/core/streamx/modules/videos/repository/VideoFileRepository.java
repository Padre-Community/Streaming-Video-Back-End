package api.core.streamx.modules.videos.repository;

import api.core.streamx.modules.videos.model.VideoFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFileRepository extends JpaRepository<VideoFile, Long> {
}
