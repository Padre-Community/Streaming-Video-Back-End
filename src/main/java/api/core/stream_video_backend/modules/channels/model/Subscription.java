package api.core.stream_video_backend.modules.channels.model;

import api.core.stream_video_backend.modules.users.model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean notifyEnabled;

    private LocalDateTime subscribedAt;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    @JsonBackReference
    private Users subscriber;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private Channel channel;
}

