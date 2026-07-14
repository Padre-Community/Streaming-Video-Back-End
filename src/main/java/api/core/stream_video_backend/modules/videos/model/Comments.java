package api.core.stream_video_backend.modules.videos.model;

import api.core.stream_video_backend.modules.users.model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String commentsMessage;

    private LocalDateTime commentsDate;

    private Integer likeCount;

    private Boolean isPinned;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "video_id")
    private Video video;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parent_id")
    private Comments parentComment;

    @OneToMany(mappedBy = "parentComment")
    @JsonManagedReference
    private List<Comments> replies;
}
