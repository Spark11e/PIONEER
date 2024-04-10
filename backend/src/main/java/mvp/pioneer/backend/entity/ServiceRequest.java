package mvp.pioneer.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {
    private UUID id;
    private UUID customerId;
    private UUID organizationId;
    private LocalDateTime start;
    private List<UUID> works;
}
