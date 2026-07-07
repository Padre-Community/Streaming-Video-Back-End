package api.core.video_max.modules.users.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "avatar", columnDefinition = "TEXT")
    private String avatar;

    private String email;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean status;

}
