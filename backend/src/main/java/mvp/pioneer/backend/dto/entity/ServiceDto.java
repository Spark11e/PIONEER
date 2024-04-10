package mvp.pioneer.backend.dto.entity;

import java.util.UUID;

public record ServiceDto(
        UUID id,
        String name,
        String code) {
}
