package mvp.pioneer.backend.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Информация об услуге")
public record ServiceDto(
        @Schema(description = "Идентификатор услуги")
        UUID id,
        @Schema(description = "Название услуги")
        String name,
        @Schema(description = "Код услуги")
        String code) {
}
