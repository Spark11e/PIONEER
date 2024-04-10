package mvp.pioneer.backend.dto.entity;

import mvp.pioneer.backend.enums.AddressType;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link mvp.pioneer.backend.entity.Address}
 */
public record AddressDto(
        UUID id,
        String subject,
        String city,
        String houseNumber,
        String street,
        AddressType addressType
) implements Serializable {
}