package mvp.pioneer.backend.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema
public record OrganizationDto(
        @Schema
        String ogrn,

        @Schema
        String kpp,

        @Schema
        String inn,

        @Schema
        String shortName,

        @Schema
        String fullName,
        @Schema
        PersonDto responsiblePerson
) {
}
