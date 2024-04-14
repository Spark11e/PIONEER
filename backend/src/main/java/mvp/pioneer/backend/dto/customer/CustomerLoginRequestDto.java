package mvp.pioneer.backend.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Информация для авторизации потребителя")
public record CustomerLoginRequestDto(
        @Schema(description = "Электронная почта", defaultValue = "customer@mail.ru")
        String email,
        @Schema(description = "Пароль", defaultValue = "customer")
        String password) {
}
