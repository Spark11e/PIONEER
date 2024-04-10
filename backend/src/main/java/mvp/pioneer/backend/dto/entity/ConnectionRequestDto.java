package mvp.pioneer.backend.dto.entity;

import mvp.pioneer.backend.dto.organization.OrganizationRegistrationRequestDto;
import mvp.pioneer.backend.enums.ConnectionRequestStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link mvp.pioneer.backend.entity.ConnectionRequest}
 */
public record ConnectionRequestDto(UUID id, ConnectionRequestStatus status, LocalDate dateEnd, LocalDate dateBegin,
                                   String regNumber,
                                   OrganizationRegistrationRequestDto organization) implements Serializable {
}