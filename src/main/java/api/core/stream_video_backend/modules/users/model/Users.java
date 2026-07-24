package api.core.stream_video_backend.modules.users.model;

import api.core.stream_video_backend.modules.channels.model.Channel;
import api.core.stream_video_backend.modules.channels.model.Subscription;
import api.core.stream_video_backend.modules.videos.model.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(unique = true)
    private String email;

    private String password;

    private String secretKey;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean status;

    @JsonManagedReference
    @OneToMany(mappedBy = "followers")
    private List<Follower> followers;

    @JsonManagedReference
    @OneToMany(mappedBy = "users")
    private List<Video> videos;

    @JsonManagedReference
    @OneToMany(mappedBy = "users")
    private List<PlayList> playLists;

    @JsonManagedReference
    @OneToMany(mappedBy = "users")
    private List<Comments> comments;

    @JsonManagedReference
    @OneToMany(mappedBy = "owner")
    private List<Channel> channels;

    @JsonManagedReference
    @OneToMany(mappedBy = "subscriber")
    private List<Subscription> subscriptions;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<WatchHistory> watchHistories;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Reaction> reactions;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<UserPlan> userPlans;

}
