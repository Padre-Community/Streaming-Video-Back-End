package api.core.stream_video_backend.modules.users.repository;

import api.core.stream_video_backend.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
