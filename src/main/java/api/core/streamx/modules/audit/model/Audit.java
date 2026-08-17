package api.core.streamx.modules.audit.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_audit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String method;
    private String uri;
    private Integer codeStatus;
    private String httpStatus;
    private String timeStamp;
}
