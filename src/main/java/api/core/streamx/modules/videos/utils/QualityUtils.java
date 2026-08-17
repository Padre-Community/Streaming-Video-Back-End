package api.core.streamx.modules.videos.utils;

import api.core.streamx.modules.exception.videos.BusinessException;
import api.core.streamx.modules.videos.enums.Quality;
import api.core.streamx.modules.videos.strategies.contracts.IQuality;
import api.core.streamx.modules.videos.strategies.quality.HighQuality;
import api.core.streamx.modules.videos.strategies.quality.LowQuality;
import api.core.streamx.modules.videos.strategies.quality.MiddleQuality;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QualityUtils {

    private static Map<Quality, IQuality> qualityMap;

    public QualityUtils() {
        qualityMap = new HashMap<>();
        qualityMap.put(Quality.LOW, new LowQuality());
        qualityMap.put(Quality.MIDDLE, new MiddleQuality());
        qualityMap.put(Quality.HIGH, new HighQuality());
    }

    public static Quality selectQuality(Quality quality) {
        IQuality iQuality = qualityMap.get(quality);
        if (iQuality != null) {
            return iQuality.selectQuality(quality);
        } else {
            throw new BusinessException("Qualidade de Vídeo não encontrada e/ou não existe");
        }
    }
}
