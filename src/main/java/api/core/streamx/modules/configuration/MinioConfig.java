package api.core.streamx.modules.configuration;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Bean
    MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint("http://localhost:9002")
                .build();
    }
}
