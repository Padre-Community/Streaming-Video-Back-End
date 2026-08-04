package api.core.stream_video_backend.modules.users.repository;

import api.core.stream_video_backend.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    @Query(value = "SELECT * FROM tb_users", nativeQuery = true)
    Users listUsers();

}
