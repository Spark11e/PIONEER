package mvp.pioneer.backend.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Информация об адрессе организации")
public record GetAddressesResponseDto(
        @Schema(description = "Идентификатор адресса")
        UUID addressId,
        @Schema(description = "Субъект Российской Федерации")
        String subject,
        @Schema(description = "Город")
        String city,
        @Schema(description = "Номер дома")
        String houseNumber,
        @Schema(description = "Улица")
        String street,
        @Schema(description = "Идентификатор организации")
        UUID organizationId,
        @Schema(description = "Короткое имя организации")
        String shortName,
        @Schema(description = "Полное имя организации")
        String fullName
) {
}
