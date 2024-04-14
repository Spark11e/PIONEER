package mvp.pioneer.backend.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Информация для регистрации потребителя")
public record CustomerRegistrationRequestDto(
        @Schema(description = "Электронная почта")
        String email,
        @Schema(description = "Пароль")
        String password,
        @Schema(description = "Номер телефона")
        String phoneNumber,
        @Schema(description = "Имя")
        String name,
        @Schema(description = "Фамилия")
        String surname,
        @Schema(description = "Отчество")
        String patronymic
) implements Serializable {
}