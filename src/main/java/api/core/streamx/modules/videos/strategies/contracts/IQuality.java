package api.core.streamx.modules.videos.strategies.contracts;

import api.core.streamx.modules.videos.enums.Quality;

public interface IQuality {
    Quality selectQuality(Quality quality);
}
