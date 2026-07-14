package api.core.stream_video_backend.modules.videos.model;

import api.core.stream_video_backend.modules.users.model.Users;
import api.core.stream_video_backend.modules.videos.enums.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_playlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playListName;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonBackReference
    private Users users;

    @OneToMany(mappedBy = "playList")
    @JsonManagedReference
    private List<Video> playListVideos;

    @OneToMany(mappedBy = "playlist")
    @JsonManagedReference
    private List<PlayListItem> playListItems;
}


