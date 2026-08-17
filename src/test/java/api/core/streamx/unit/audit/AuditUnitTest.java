package api.core.streamx.unit.audit;

import api.core.streamx.modules.audit.model.Audit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AuditUnitTest {

    @Test
    void shouldCreateAuditWithAllArgsConstructor() {
        Audit audit = new Audit(
                1L,
                "GET",
                "/videos/1",
                200,
                "OK",
                "2026-08-14T01:14:59.031-03:00"
        );

        assertAll(
                () -> assertEquals(1L, audit.getId()),
                () -> assertEquals("GET", audit.getMethod()),
                () -> assertEquals("/videos/1", audit.getUri()),
                () -> assertEquals(200, audit.getCodeStatus()),
                () -> assertEquals("OK", audit.getHttpStatus()),
                () -> assertEquals("2026-08-14T01:14:59.031-03:00", audit.getTimeStamp())
        );
    }

    @Test
    void shouldSetAndGetAuditFields() {
        Audit audit = new Audit();

        audit.setId(10L);
        audit.setMethod("POST");
        audit.setUri("/users");
        audit.setCodeStatus(201);
        audit.setHttpStatus("Created");
        audit.setTimeStamp("2026-08-14T02:00:00Z");

        assertAll(
                () -> assertEquals(10L, audit.getId()),
                () -> assertEquals("POST", audit.getMethod()),
                () -> assertEquals("/users", audit.getUri()),
                () -> assertEquals(201, audit.getCodeStatus()),
                () -> assertEquals("Created", audit.getHttpStatus()),
                () -> assertEquals("2026-08-14T02:00:00Z", audit.getTimeStamp())
        );
    }

    @Test
    void shouldInitializeAuditFieldsAsNull() {
        Audit audit = new Audit();

        assertAll(
                () -> assertNull(audit.getId()),
                () -> assertNull(audit.getMethod()),
                () -> assertNull(audit.getUri()),
                () -> assertNull(audit.getCodeStatus()),
                () -> assertNull(audit.getHttpStatus()),
                () -> assertNull(audit.getTimeStamp())
        );
    }
}
