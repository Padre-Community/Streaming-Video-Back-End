package api.core.stream_video_backend.modules.channels.model;

import api.core.stream_video_backend.modules.users.model.Users;
import api.core.stream_video_backend.modules.videos.model.Video;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_channels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Channel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String slug;

    private String description;

    @Column(name = "banner_url", columnDefinition = "TEXT")
    private String bannerUrl;

    private Integer subscriberCount;

    private Boolean isMonetized;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Users owner;

    @OneToMany(mappedBy = "channel")
    @JsonManagedReference
    private List<Video> videos;

    @OneToMany(mappedBy = "channel")
    @JsonManagedReference
    private List<Subscription> subscriptions;
}


