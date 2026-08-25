package api.core.streamx.modules.analytics.controller;

import api.core.streamx.modules.analytics.dto.response.AnalyticsResponse;
import api.core.streamx.modules.analytics.services.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping(path = "/analytics")
    public ResponseEntity<AnalyticsResponse> numberOfCommentsFromUser(@RequestParam("id_user") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(analyticsService.numberOfCommentsFromUser(id));
    }
}
