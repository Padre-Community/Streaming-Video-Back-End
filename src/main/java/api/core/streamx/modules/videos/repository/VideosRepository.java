package api.core.streamx.modules.videos.repository;

import api.core.streamx.modules.videos.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideosRepository extends JpaRepository<Video, Long> {

    @Query("SELECT v FROM Video v WHERE v.category.id = :categoryId")
    List<Video> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT count(*) as counter FROM tb_videos v WHERE v.liked=true", nativeQuery = true)
    Integer countLikeVideos();
}
