package api.core.video_max.modules.videos.model;

import api.core.video_max.modules.users.model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_videos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Videos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channel;

    private String title;

    private String description;

    private String url;

    private String recordCode;

    private LocalDateTime shippingDate;

    private Boolean liked;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonBackReference
    private Users users;

    @Override
    public String toString() {
        return "Videos{" +
                "id=" + id +
                ", channel='" + channel + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", recordCode='" + recordCode + '\'' +
                ", shippingDate=" + shippingDate +
                ", liked=" + liked +
                ", usersId=" + (users != null ? users.getId() : null) +
                '}';
    }
}
