package mvp.pioneer.backend.dto.entity;

import java.math.BigDecimal;

public record WorkDto(
        Integer duration,
        BigDecimal cost,
        String name,
        String code
) {
}
