package api.core.stream_video_backend.modules.videos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_playlist_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayListItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer position;

    private LocalDateTime addedAt;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    @JsonBackReference
    private PlayList playlist;

    @ManyToOne
    @JoinColumn(name = "video_id")
    @JsonBackReference
    private Video video;
}

