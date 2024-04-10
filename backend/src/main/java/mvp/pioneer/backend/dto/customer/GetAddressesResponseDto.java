package mvp.pioneer.backend.dto.customer;

public record GetAddressesResponseDto(
        String subject,
        String city,
        String houseNumber,
        String street,
        String shortName,
        String fullName
) {
}
