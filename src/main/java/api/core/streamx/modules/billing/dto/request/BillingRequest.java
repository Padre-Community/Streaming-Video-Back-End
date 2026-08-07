package api.core.streamx.modules.billing.dto.request;

import java.math.BigDecimal;

public record BillingRequest(String name, BigDecimal price) {
}
