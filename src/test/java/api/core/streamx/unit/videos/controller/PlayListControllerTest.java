package api.core.streamx.unit.videos.controller;

import api.core.streamx.modules.videos.controller.PlayListController;
import api.core.streamx.modules.videos.dto.response.PlaylistResponse;
import api.core.streamx.modules.videos.services.PlayListServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PlayListControllerTest {

    private MockMvc mockMvc;
    private PlayListServices service;

    @BeforeEach
    void setUp() {
        service = mock(PlayListServices.class);

        PlayListController controller = new PlayListController(service);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }

    @Test
    void deveAtualizarPlaylist() throws Exception {
        when(service.atualizarNome(10L, "Favoritos 2026"))
                .thenReturn(new PlaylistResponse(
                        10L,
                        "Favoritos 2026",
                        null,
                        null
                ));

        mockMvc.perform(put("/playlists/update")
                        .param("id", "10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "playListName": "Favoritos 2026"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.playListName")
                        .value("Favoritos 2026"));
    }
}