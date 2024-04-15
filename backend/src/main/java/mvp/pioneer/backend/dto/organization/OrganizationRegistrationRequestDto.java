package mvp.pioneer.backend.dto.organization;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Информация, необходимая для регистрации организации")
public record OrganizationRegistrationRequestDto(
        @Schema(description = "ОРГН")
        String ogrn,
        @Schema(description = "КПП")
        String kpp,
        @Schema(description = "ИНН")
        String inn,
        @Schema(description = "Сокращенное наименование организации")
        String shortName,
        @Schema(description = "Полное наименование организации")
        String fullName,
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
        String patronymic) {
}
