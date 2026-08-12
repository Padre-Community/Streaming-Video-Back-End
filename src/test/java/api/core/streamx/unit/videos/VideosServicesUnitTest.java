package api.core.streamx.unit.videos;

import api.core.streamx.modules.videos.dto.response.VideosResponse;
import api.core.streamx.modules.videos.model.Video;
import api.core.streamx.modules.videos.repository.VideosRepository;
import api.core.streamx.modules.videos.services.VideosServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VideosServicesUnitTest {

    @Mock
    VideosRepository videosRepository;

    @InjectMocks
    VideosServices videosServices;

    @Test
    void shouldReturnMappedVideosWhenCategoryHasVideos() {
        Long categoryId = 1L;

        Video video = Video.builder()
                .id(1L)
                .title("Vídeo Teste")
                .channelName("Canal Teste")
                .thumbnailUrl("http://...")
                .durationSeconds(600)
                .viewCount(1000L)
                .build();

        when(videosRepository.findByCategoryId(categoryId)).thenReturn(List.of(video));

        List<VideosResponse> resultado = videosServices.listVideosByCategory(categoryId);

        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).id()).isEqualTo(1L);
        assertThat(resultado.get(0).channelName()).isEqualTo("Canal Teste");
        assertThat(resultado.get(0).title()).isEqualTo("Vídeo Teste");
        assertThat(resultado.get(0).thumbnailUrl()).isEqualTo("http://...");
        assertThat(resultado.get(0).durationSeconds()).isEqualTo(600);
        assertThat(resultado.get(0).viewCount()).isEqualTo(1000L);

        verify(videosRepository).findByCategoryId(categoryId);
    }
}
