package api.core.streamx.integration.videos;

import api.core.streamx.modules.audit.repository.AuditRepository;
import api.core.streamx.modules.videos.controller.VideosController;
import api.core.streamx.modules.videos.dto.response.VideosResponse;
import api.core.streamx.modules.videos.services.VideoServicesImpl;
import api.core.streamx.modules.videos.services.VideosServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = VideosController.class)
public class VideosIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    VideoServicesImpl videosServices;

    @MockitoBean
    AuditRepository auditRepository;

    @Test
    void shouldListVideosByCategoryAndReturnOk() throws Exception {
        Long categoryId = 1L;

        VideosResponse videoFalso = new VideosResponse(
                "Canal Teste",
                "Vídeo Teste",
                "http://...",
                600,
                1000L
        );

        List<VideosResponse> listaFalsa = List.of(videoFalso);

        when(videosServices.findVideosByCategory(categoryId)).thenReturn(listaFalsa);

        mockMvc.perform(get("/api/video/category")
                        .param("category_id", String.valueOf(categoryId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].channelName").value("Canal Teste"))
                .andExpect(jsonPath("$[0].title").value("Vídeo Teste"))
                .andExpect(jsonPath("$[0].thumbnailUrl").value("http://..."))
                .andExpect(jsonPath("$[0].durationSeconds").value(600))
                .andExpect(jsonPath("$[0].viewCount").value(1000L));
        verify(videosServices).findVideosByCategory(categoryId);
    }

    @Test
    void shouldReturnEmptyListWhenCategoryHasNoVideos() throws Exception {
        Long categoryId = 99L;

        when(videosServices.findVideosByCategory(categoryId)).thenReturn(List.of());

        mockMvc.perform(get("/api/video/category")
                        .param("category_id", String.valueOf(categoryId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());

        verify(videosServices).findVideosByCategory(categoryId);
    }
}