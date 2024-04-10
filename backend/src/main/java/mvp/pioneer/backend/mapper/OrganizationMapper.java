package mvp.pioneer.backend.mapper;

import mvp.pioneer.backend.dto.entity.AddressDto;
import mvp.pioneer.backend.dto.entity.OrganizationDto;
import mvp.pioneer.backend.dto.entity.ServiceRequestDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.dto.organization.OrganizationRegistrationRequestDto;
import mvp.pioneer.backend.entity.Address;
import mvp.pioneer.backend.entity.ConnectionRequest;
import mvp.pioneer.backend.entity.Organization;
import mvp.pioneer.backend.entity.ServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationMapper {

    ServiceRequestDto toServiceRequestDto(ServiceRequest serviceRequest);

    Organization toOrganization(OrganizationRegistrationRequestDto requestDto);

    OrganizationDto toOrganizationDto(Organization organization);

    ConnectionRequestDto toConnectionRequestDto(ConnectionRequest connectionRequest);

    AddressDto toAddressDto(Address address);

    Address toAddress(AddressDto addressDto);

    List<AddressDto> toAddressDtoList(List<Address> addresses);

    List<ConnectionRequestDto> toConnectionRequestDtoList(List<ConnectionRequest> connectionRequests);
}