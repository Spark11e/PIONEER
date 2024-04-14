package mvp.pioneer.backend.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Информация об организации")
public record OrganizationDto(
        @Schema(description = "Идентификатор организации")
        UUID id,
        @Schema(description = "ОРГН")
        String ogrn,
        @Schema(description = "КПП")
        String kpp,
        @Schema(description = "ИНН")
        String inn,
        @Schema(description = "Сокращенное наименование организации")
        String shortName,
        @Schema(description = "Полное наименование организации")
        String fullName,
        @Schema(description = "Информация об ответственном лице")
        PersonDto responsiblePerson) {
}
