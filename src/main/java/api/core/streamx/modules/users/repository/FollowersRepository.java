package api.core.streamx.modules.users.repository;

import api.core.streamx.modules.users.model.Follower;
import api.core.streamx.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowersRepository extends JpaRepository<Follower, Long> {

    @Query("SELECT u FROM Follower f JOIN Users u ON u.id = f.followerId WHERE f.followers.id = :id")
    List<Users> findFollowers(Long id);

    @Query(value = "SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM tb_follower f WHERE f.user_id =:userId AND f.follower_id =:followerId", nativeQuery = true)
    boolean existsByUserIdAndFollowerId(@Param("userId")     Long userId,
                                        @Param("followerId") Long followerId);
}
