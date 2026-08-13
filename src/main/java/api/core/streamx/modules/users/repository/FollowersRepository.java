package api.core.streamx.modules.users.repository;

import api.core.streamx.modules.users.model.Follower;
import api.core.streamx.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowersRepository extends JpaRepository<Follower, Long> {

    @Query("SELECT u FROM Follower f JOIN Users u ON u.id = f.followerId WHERE f.followers.id = :id")
    List<Users> findFollowers(Long id);
}
