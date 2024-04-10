package mvp.pioneer.backend.dto.customer;

import java.io.Serializable;

public record CustomerRegistrationRequestDto(
        String email,
        String password,
        String phoneNumber,
        String name,
        String surname,
        String patronymic
) implements Serializable {
}