package api.core.streamx.modules.channels.model;

import api.core.streamx.modules.users.model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Column(name = "subscribed_at", nullable = false)
    private LocalDateTime subscribedAt;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    @JsonBackReference
    private Users subscriber;

    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    @JsonBackReference
    private Channel channel;
}

