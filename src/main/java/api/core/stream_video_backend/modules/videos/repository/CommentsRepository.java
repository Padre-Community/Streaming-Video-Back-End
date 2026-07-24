package api.core.stream_video_backend.modules.videos.repository;

import api.core.stream_video_backend.modules.videos.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>
{
}
