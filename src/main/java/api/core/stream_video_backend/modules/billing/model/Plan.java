package api.core.stream_video_backend.modules.billing.model;

import api.core.stream_video_backend.modules.users.model.UserPlan;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_plans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal priceBrl;

    private String billingCycle;

    @Column(name = "features", columnDefinition = "jsonb")
    private String features;

    @OneToMany(mappedBy = "plan")
    @JsonManagedReference
    private List<UserPlan> userPlans;
}

