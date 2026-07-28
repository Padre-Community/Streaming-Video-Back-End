package api.core.stream_video_backend.modules.videos.repository;

import api.core.stream_video_backend.modules.videos.model.VideoFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoFileRepository extends JpaRepository<VideoFile, Long> {
}
