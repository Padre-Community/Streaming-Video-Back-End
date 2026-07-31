package api.core.stream_video_backend.modules.channels.repository;

import api.core.stream_video_backend.modules.channels.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
