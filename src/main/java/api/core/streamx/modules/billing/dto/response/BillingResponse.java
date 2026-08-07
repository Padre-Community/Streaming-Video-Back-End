package api.core.streamx.modules.billing.dto.response;

import java.math.BigDecimal;

public record BillingResponse(Long id, String name, BigDecimal priceBrl) {
}
