package api.core.stream_video_backend.modules.videos.model;

import api.core.stream_video_backend.modules.channels.model.Channel;
import api.core.stream_video_backend.modules.users.model.Users;
import api.core.stream_video_backend.modules.videos.enums.StatusVideo;
import api.core.stream_video_backend.modules.videos.enums.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_videos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channelName;

    private String title;

    private String description;

    @Column(name = "thumbnail_url", columnDefinition = "TEXT")
    private String thumbnailUrl;

    private String url;

    private String recordCode;

    @Enumerated(EnumType.STRING)
    private StatusVideo statusVideo;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    private Integer durationSeconds;

    private Long viewCount;

    private Integer likeCount;

    @Column(name = "tags", columnDefinition = "jsonb")
    private String tags;

    @Column(name = "chapters", columnDefinition = "jsonb")
    private String chapters;

    private LocalDateTime publishedAt;

    private LocalDateTime shippingDate;

    private Boolean liked;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonBackReference
    private Users users;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private Channel channel;

    @OneToMany(mappedBy = "video")
    @JsonManagedReference
    private List<Comments> comments;

    @OneToMany(mappedBy = "video")
    @JsonManagedReference
    private List<VideoFile> videoFiles;

    @ManyToOne
    @JoinColumn(name = "playList_id")
    @JsonBackReference
    private PlayList playList;

    @OneToMany(mappedBy = "video")
    @JsonManagedReference
    private List<PlayListItem> playListItems;

    @OneToMany(mappedBy = "video")
    @JsonManagedReference
    private List<WatchHistory> watchHistories;

    @OneToMany(mappedBy = "video")
    @JsonManagedReference
    private List<Reaction> reactions;

}