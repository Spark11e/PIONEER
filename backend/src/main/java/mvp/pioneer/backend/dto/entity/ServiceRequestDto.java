package mvp.pioneer.backend.dto.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link mvp.pioneer.backend.entity.ServiceRequest}
 */
public record ServiceRequestDto(
        UUID id,
        UUID customerId,
        UUID organizationId, LocalDateTime start,
        List<UUID> works) implements Serializable {
}