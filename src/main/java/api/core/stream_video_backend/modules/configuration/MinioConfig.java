package api.core.stream_video_backend.modules.configuration;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Bean
    MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint("http://localhost:9002")
                .credentials("video-max@video-max.com", "video-max@video-max.com")
                .build();
    }
}
