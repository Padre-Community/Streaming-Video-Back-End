package api.core.streamx.e2e.users;

import api.core.streamx.modules.users.model.Follower;
import api.core.streamx.modules.users.model.Users;
import api.core.streamx.modules.users.repository.FollowersRepository;
import api.core.streamx.modules.users.repository.UsersRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

@DirtiesContext
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersE2ETest {

    @Autowired
    private FollowersRepository followersRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test")
            .withReuse(true);

    @LocalServerPort
    private int port;

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        followersRepository.deleteAll();
        usersRepository.deleteAll();

        Users user = createUser("User", "user@email.com");
        Users user1 = createUser("user1", "user1@email.com");
        Users user2 = createUser("user2", "user2@email.com");
        Users user3 = createUser("user3", "user3@email.com");

        usersRepository.saveAll(
                java.util.List.of(user, user1, user2, user3)
        );

        followersRepository.save(
                Follower.builder()
                        .followerId(user1.getId())
                        .nameFollower(user1.getName())
                        .followers(user)
                        .build()
        );

        followersRepository.save(
                Follower.builder()
                        .followerId(user2.getId())
                        .nameFollower(user2.getName())
                        .followers(user)
                        .build()
        );

        followersRepository.save(
                Follower.builder()
                        .followerId(user3.getId())
                        .nameFollower(user3.getName())
                        .followers(user)
                        .build()
        );
    }

    private Users createUser(String name, String email) {

        LocalDateTime now = LocalDateTime.now();

        return Users.builder()
                .name(name)
                .email(email)
                .password("123456")
                .createdAt(now)
                .updatedAt(now)
                .status(true)
                .build();
    }

    @Test
    void testCreateUsersFlow() {
        given()
                .queryParam("name", "Goku Kakaroto")
                .queryParam("email", "goku@capsulecorps.com")
                .queryParam("password", "admin123")
                .when()
                .post("/api/users/save")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }


}
