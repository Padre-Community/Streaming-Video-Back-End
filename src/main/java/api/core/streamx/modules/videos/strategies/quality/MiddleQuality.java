package api.core.streamx.modules.videos.strategies.quality;

import api.core.streamx.modules.videos.enums.Quality;
import api.core.streamx.modules.videos.strategies.contracts.IQuality;

public class MiddleQuality implements IQuality {

    @Override
    public Quality selectQuality(Quality quality) {
        return quality;
    }
}
