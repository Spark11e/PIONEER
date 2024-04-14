package mvp.pioneer.backend.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "Информация о работе")
public record WorkDto(
        @Schema(description = "Идентификатор работы")
        UUID id,
        @Schema(description = "Длительность работы")
        Integer duration,
        @Schema(description = "Стоимость работы")
        BigDecimal cost,
        @Schema(description = "Название работы")
        String name,
        @Schema(description = "Код работы")
        String code
) {
}
