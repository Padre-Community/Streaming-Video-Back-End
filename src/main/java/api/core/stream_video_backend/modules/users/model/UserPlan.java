package api.core.stream_video_backend.modules.users.model;

import api.core.stream_video_backend.modules.billing.model.Plan;
import api.core.stream_video_backend.modules.users.enums.StatusUserPlan;
import api.core.stream_video_backend.modules.videos.model.Video;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user_plans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusUserPlan status;

    private LocalDateTime startsAt;

    private LocalDateTime endsAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    @JsonBackReference
    private Plan plan;
}

