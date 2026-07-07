package api.core.video_max;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

@Slf4j
@SpringBootApplication
public class StreamingVideoBackEnd {

    public static void main(String[] args) {
        SpringApplication.run(StreamingVideoBackEnd.class, args);
        log.info("VideoMaxApplication Started {}", HttpStatus.OK);
    }
}
