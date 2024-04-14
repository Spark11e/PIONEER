package mvp.pioneer.backend.dto.aggregator;

import io.swagger.v3.oas.annotations.media.Schema;
import mvp.pioneer.backend.enums.ConnectionRequestStatus;

@Schema(description = "Информация для изменения статуса заявки органзиации")
public record PatchConnectionRequestRequestDto(
        @Schema(description = "Новый статус заявки")
        ConnectionRequestStatus status) {
}
