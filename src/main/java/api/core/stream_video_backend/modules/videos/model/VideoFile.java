package api.core.stream_video_backend.modules.videos.model;

import api.core.stream_video_backend.modules.videos.enums.Quality;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_video_files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Quality quality;

    private String storageKey;

    private String hlsManifestUrl;

    private Long fileSizeBytes;

    private String codec;

    private Integer bitrateKbps;

    @ManyToOne
    @JoinColumn(name = "video_id")
    @JsonBackReference
    private Video video;
}

