package api.core.streamx.modules.videos.repository;

import api.core.streamx.modules.videos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
