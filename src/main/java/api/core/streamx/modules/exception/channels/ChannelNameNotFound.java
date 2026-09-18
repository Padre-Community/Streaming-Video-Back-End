package api.core.streamx.modules.exception.channels;

public class ChannelNameNotFound extends RuntimeException {
    public ChannelNameNotFound(String message) {
        super(message);
    }
}
