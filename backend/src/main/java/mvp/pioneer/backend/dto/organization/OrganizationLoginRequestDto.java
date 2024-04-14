package mvp.pioneer.backend.dto.organization;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Информация для авторизации ответственного за организацию лица")
public record OrganizationLoginRequestDto(
        @Schema(description = "Электронная почта", defaultValue = "responsible@mail.ru")
        String email,
        @Schema(description = "Пароль", defaultValue = "responsible")
        String password) {
}
