package api.core.streamx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

@Slf4j
@SpringBootApplication
public class StreamxApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamxApplication.class, args);
        log.info("StreamxApplication Started {}", HttpStatus.OK);
    }
}
