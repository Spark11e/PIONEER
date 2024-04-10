package mvp.pioneer.backend.dto.aggregator;

import java.io.Serializable;
import java.util.UUID;

public record AggregatorAuthResponseDto(
        UUID id,
        String email,
        String phoneNumber,
        String name,
        String surname,
        String patronymic
) implements Serializable {
}
