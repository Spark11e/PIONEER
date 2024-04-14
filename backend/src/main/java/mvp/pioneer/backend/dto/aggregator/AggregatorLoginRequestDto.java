package mvp.pioneer.backend.dto.aggregator;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Информация для авторизации сотрудника")
public record AggregatorLoginRequestDto(
        @Schema(description = "Электронная почта", defaultValue = "aggregator@mail.ru")
        String email,
        @Schema(description = "Пароль", defaultValue = "aggregator")
        String password
) {
}
