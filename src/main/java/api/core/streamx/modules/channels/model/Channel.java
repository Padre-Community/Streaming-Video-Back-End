package api.core.streamx.modules.channels.model;

import api.core.streamx.modules.users.model.Users;
import api.core.streamx.modules.videos.model.Video;
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

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "banner_url", columnDefinition = "TEXT")
    private String bannerUrl;

    @Column(name = "subscriber_count")
    private Integer subscriberCount;

    @Column(name = "is_monetized")
    private Boolean isMonetized;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Users owner;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Video> videos;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Subscription> subscriptions;
}


