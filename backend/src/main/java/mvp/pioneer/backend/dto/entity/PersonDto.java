package mvp.pioneer.backend.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link mvp.pioneer.backend.entity.Person}
 */
@Schema(description = "Информация о личности, зарегистрированной в приложении")
public record PersonDto(
        @Schema(description = "Идентификатор личности")
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
        String patronymic
) implements Serializable {
}