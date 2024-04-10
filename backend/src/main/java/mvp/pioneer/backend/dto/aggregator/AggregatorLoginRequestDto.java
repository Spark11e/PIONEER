package mvp.pioneer.backend.dto.aggregator;

public record AggregatorLoginRequestDto(
        String email,
        String password
) {
}
