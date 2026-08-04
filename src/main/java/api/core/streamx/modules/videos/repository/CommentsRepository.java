package api.core.streamx.modules.videos.repository;

import api.core.streamx.modules.videos.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>
{
}
