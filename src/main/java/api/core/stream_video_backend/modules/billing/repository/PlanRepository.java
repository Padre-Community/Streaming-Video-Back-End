package api.core.stream_video_backend.modules.billing.repository;

import api.core.stream_video_backend.modules.billing.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
