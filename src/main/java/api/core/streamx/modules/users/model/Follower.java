package api.core.streamx.modules.users.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_follower")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Follower implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long followerId;

    private String nameFollower;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users followers;
}
