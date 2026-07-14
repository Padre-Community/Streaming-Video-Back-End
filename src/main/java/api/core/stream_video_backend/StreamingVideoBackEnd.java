package api.core.stream_video_backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

@Slf4j
@SpringBootApplication
public class StreamingVideoBackEnd {

    public static void main(String[] args) {
        SpringApplication.run(StreamingVideoBackEnd.class, args);
        log.info("StreamingVideoBackEnd Started {}", HttpStatus.OK);
    }
}
