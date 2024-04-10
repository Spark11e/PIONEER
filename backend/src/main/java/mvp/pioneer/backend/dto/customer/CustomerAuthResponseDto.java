package mvp.pioneer.backend.dto.customer;

import java.io.Serializable;
import java.util.UUID;

public record CustomerAuthResponseDto(
        UUID id,
        String email,
        String phoneNumber,
        String name,
        String surname,
        String patronymic) implements Serializable {
}