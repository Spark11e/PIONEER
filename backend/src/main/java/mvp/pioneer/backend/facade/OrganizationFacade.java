package mvp.pioneer.backend.facade;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.dto.entity.AddressDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.dto.entity.OrganizationDto;
import mvp.pioneer.backend.dto.organization.OrganizationLoginRequestDto;
import mvp.pioneer.backend.dto.organization.OrganizationRegistrationRequestDto;
import mvp.pioneer.backend.entity.ServiceRequest;
import mvp.pioneer.backend.mapper.OrganizationMapper;
import mvp.pioneer.backend.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationFacade {

    private final OrganizationService organizationService;

    private final OrganizationMapper organizationMapper;

    public ServiceRequest getServiceRequest(UUID organizationId) {
        return organizationService.getServiceRequest(organizationId);
    }

    public OrganizationDto registration(OrganizationRegistrationRequestDto requestDto) {
        return organizationMapper.toOrganizationDto(organizationService.registration(organizationMapper.toOrganization(requestDto)));
    }

    public List<AddressDto> getAddresses(UUID id) {
        return organizationMapper.toAddressDtoList(organizationService.getAddresses(id));
    }

    public AddressDto putAddress(AddressDto addressDto) {
        return organizationMapper.toAddressDto(organizationService.putAddress(organizationMapper.toAddress(addressDto)));
    }

    public OrganizationDto login(OrganizationLoginRequestDto requestDto) {
        return organizationMapper.toOrganizationDto(organizationService.login(requestDto.email(), requestDto.password()));
    }

    public List<ConnectionRequestDto> getConnectionRequests(UUID id) {
        return organizationMapper.toConnectionRequestDtoList(organizationService.getConnectionRequests(id));
    }

    public ConnectionRequestDto sendConnectionRequests(UUID id) {
        return organizationMapper.toConnectionRequestDto(organizationService.sendConnectionRequest(id));
    }
}
