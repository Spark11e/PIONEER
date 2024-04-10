package mvp.pioneer.backend.dto.aggregator;

import mvp.pioneer.backend.enums.ConnectionRequestStatus;

public record PatchConnectionRequestRequestDto(ConnectionRequestStatus status) {
}
