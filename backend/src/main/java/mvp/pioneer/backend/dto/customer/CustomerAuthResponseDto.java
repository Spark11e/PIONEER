package mvp.pioneer.backend.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.UUID;

@Schema(description = "Информация об авторизированном потребителе")
public record CustomerAuthResponseDto(
        @Schema(description = "Уникальный идентификатор")
        UUID id,
        @Schema(description = "Электронная почта")
        String email,
        @Schema(description = "Номер телефона")
        String phoneNumber,
        @Schema(description = "Имя")
        String name,
        @Schema(description = "Фамилия")
        String surname,
        @Schema(description = "Отчество")
        String patronymic) implements Serializable {
}