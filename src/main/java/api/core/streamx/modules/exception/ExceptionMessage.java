package api.core.streamx.modules.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Builder
public class ExceptionMessage {

    private Integer statusNumber;
    private HttpStatus errorStatus;
    private String timestamp;
    private List<String> messages;
}
