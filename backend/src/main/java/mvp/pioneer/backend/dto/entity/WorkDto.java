package mvp.pioneer.backend.dto.entity;

import java.math.BigDecimal;
import java.util.UUID;

public record WorkDto(
        UUID id,
        Integer duration,
        BigDecimal cost,
        String name,
        String code
) {
}
