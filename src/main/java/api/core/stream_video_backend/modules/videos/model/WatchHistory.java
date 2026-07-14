package api.core.stream_video_backend.modules.videos.model;

import api.core.stream_video_backend.modules.users.model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_watch_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WatchHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer lastPositionSec;

    private Boolean completed;

    private LocalDateTime watchedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;

    @ManyToOne
    @JoinColumn(name = "video_id")
    @JsonBackReference
    private Video video;
}

