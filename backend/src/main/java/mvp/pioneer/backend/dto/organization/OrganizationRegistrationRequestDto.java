package mvp.pioneer.backend.dto.organization;

import mvp.pioneer.backend.dto.entity.OrganizationDto;
import mvp.pioneer.backend.dto.entity.PersonDto;

public record OrganizationRegistrationRequestDto(
        OrganizationDto organizationData,
        PersonDto responsiblePerson
) {
}
