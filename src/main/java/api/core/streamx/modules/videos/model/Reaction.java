package api.core.streamx.modules.videos.model;

import api.core.streamx.modules.users.model.Users;
import api.core.streamx.modules.videos.enums.ReactionVideo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReactionVideo reactionVideo;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;

    @ManyToOne
    @JoinColumn(name = "video_id")
    @JsonBackReference
    private Video video;
}

