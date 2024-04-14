package mvp.pioneer.backend.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import mvp.pioneer.backend.enums.AddressType;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link mvp.pioneer.backend.entity.Address}
 */
@Schema(description = "Информация об адрессе")
public record AddressDto(
        @Schema(description = "Идентификатор адресса")
        UUID id,
        @Schema(description = "Субъект Российской Федерации")
        String subject,
        @Schema(description = "Город")
        String city,

        @Schema(description = "Номер дома")
        String houseNumber,
        @Schema(description = "Улица")
        String street,
        @Schema(description = "Тип адресса (физический/юридический)")
        AddressType addressType
) implements Serializable {
}