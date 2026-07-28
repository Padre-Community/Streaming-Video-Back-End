package api.core.stream_video_backend.modules.channels.model;

import api.core.stream_video_backend.modules.users.model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(name = "notify_enable", nullable = false)
    private Boolean notifyEnabled;

    @Column(name = "subscribed_at", nullable = false)
    private LocalDateTime subscribedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id", nullable = false)
    private Users subscriber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @PrePersist
    protected void onCreate(){
        if (this.subscribedAt == null){
            this.subscribedAt = LocalDateTime.now();
        }
        if (this.notifyEnabled == null) {
            this.notifyEnabled = true;
        }
    }
}

