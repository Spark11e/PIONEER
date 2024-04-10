package mvp.pioneer.backend.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public record CustomerLoginRequestDto(@Schema String email, @Schema String password) {
}
