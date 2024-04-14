package mvp.pioneer.backend.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import mvp.pioneer.backend.enums.ConnectionRequestStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link mvp.pioneer.backend.entity.ConnectionRequest}
 */
@Schema(description = "Информация о заявки организации на регристрацию в приложении")
public record ConnectionRequestDto(
        @Schema(description = "Идентификатор заявки")
        UUID id,
        @Schema(description = "Статус заявки")
        ConnectionRequestStatus status,
        @Schema(description = "Дата закрытия заявки")
        LocalDate dateEnd,
        @Schema(description = "Дата создания заявки")
        LocalDate dateBegin,
        @Schema(description = "Регистрационный номер")
        String regNumber,
        @Schema(description = "Информация об организации")
        OrganizationDto organization
) implements Serializable {
}