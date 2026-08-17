package api.core.streamx.modules.playlist.model;

import api.core.streamx.modules.users.model.Users;
import api.core.streamx.modules.videos.enums.Visibility;
import api.core.streamx.modules.videos.model.PlayListItem;
import api.core.streamx.modules.videos.model.Video;
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


