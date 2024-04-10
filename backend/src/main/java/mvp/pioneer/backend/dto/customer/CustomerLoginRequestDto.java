package mvp.pioneer.backend.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public record CustomerLoginRequestDto(
        @Schema(defaultValue = "customer@mail.ru")
        String email,
        @Schema(defaultValue = "customer")
        String password) {
}
