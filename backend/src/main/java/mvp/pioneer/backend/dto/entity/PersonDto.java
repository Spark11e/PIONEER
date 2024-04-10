package mvp.pioneer.backend.dto.entity;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link mvp.pioneer.backend.entity.Person}
 */
public record PersonDto(
        UUID id,
        String email,
        String phoneNumber,
        String name,
        String surname,
        String patronymic
) implements Serializable {
}