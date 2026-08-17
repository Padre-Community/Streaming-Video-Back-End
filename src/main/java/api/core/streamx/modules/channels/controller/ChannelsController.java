package api.core.streamx.modules.channels.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/channels")
public class ChannelsController {

    public ResponseEntity<?> createChannel() {

        // Implementation Caller here
        // {"channelName: "channelName", "description": "description" }
        return null;
    }

    public ResponseEntity<?> fetchChannelByName(String channelName) {

        // Implementation Caller here
        // {"channelName": "channelName", "owner": "userName", "videos": ["video1", "video2", "video3"] }
        return null;
    }
}
