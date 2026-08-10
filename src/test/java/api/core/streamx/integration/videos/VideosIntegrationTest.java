package api.core.streamx.integration.videos;

import api.core.streamx.modules.videos.controller.VideosController;
import api.core.streamx.modules.videos.dto.response.VideosResponse;
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
    VideosServices videosServices;

    @Test
    void shouldListVideosByCategoryAndReturnOk() throws Exception {
        Long categoryId = 1L;

        VideosResponse videoFalso = new VideosResponse(
                1L,
                "Canal Teste",
                "Vídeo Teste",
                "http://...",
                600,
                1000L
        );

        List<VideosResponse> listaFalsa = List.of(videoFalso);

        when(videosServices.listVideosByCategory(categoryId)).thenReturn(listaFalsa);

        mockMvc.perform(get("/api/video/category")
                        .param("category_id", String.valueOf(categoryId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Vídeo Teste"));

        verify(videosServices).listVideosByCategory(categoryId);
    }
}