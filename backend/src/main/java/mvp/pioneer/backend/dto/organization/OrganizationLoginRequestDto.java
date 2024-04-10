package mvp.pioneer.backend.dto.organization;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public record OrganizationLoginRequestDto(@Schema String email, @Schema String password) {
}
