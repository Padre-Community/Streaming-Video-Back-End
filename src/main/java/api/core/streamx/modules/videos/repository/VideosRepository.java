package api.core.streamx.modules.videos.repository;

import api.core.streamx.modules.videos.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideosRepository extends JpaRepository<Video, Long>
{

}
