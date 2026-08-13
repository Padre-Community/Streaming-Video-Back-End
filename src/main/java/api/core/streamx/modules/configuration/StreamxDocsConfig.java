package api.core.streamx.modules.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StreamxDocsConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server release = new Server();
        release.setUrl("http://localhost:8080");
        release.setDescription("Server de release");

        Server production = new Server();
        production.setUrl("http://localhost:8080");
        production.setDescription("Server de produção");

        return new OpenAPI()
                .servers(Arrays.asList(release, production))
                .info(new Info()
                        .title("Aplicação de Streaming Video StreamX da Padre Community")
                        .description("""
                                 O projeto consiste na construção de uma plataforma Web/API para entretenimento e criação de videos/streams
                                 Baseado em plataformas como Vimeo, Wistia, Brightcove e Youtube, o intuito é, o entretenimento visual com conceito de diversão, informação, educação e o fomento da liberdade cultural e visual
                                 Sendo assim, foram criados os serviços:
                                * Página Web para visualização e cadastramento dos usuários
                                * Publicação de videos
                                * Publicação de comentários
                                * Listar usuários cadastrados
                                * Seguir usuários
                                * Encontrar usuário(s) e/ou video(s) por filtragem (por letra/terminação inicial e/ou final) ou seu nome/sobrenome""")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0")
                                              .url("https://www.apache.org/licenses/LICENSE-2.0"))

                        .contact(new Contact().name("Discord da Padre Community")
                                              .email("padre.community@padre.community.com")
                                              .url("https://discord.com/channels/1517630696099680456/1517632154463506583")))

                .externalDocs(new ExternalDocumentation()
                        .description("Documentação do Projeto da Padre Community")
                        .url("https://github.com/Padre-Community/Streaming-Video-Back-End/blob/develop/README.md"));
    }
}
