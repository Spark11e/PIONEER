package mvp.pioneer.backend.mapper;

import mvp.pioneer.backend.dto.customer.GetAddressesResponseDto;
import mvp.pioneer.backend.dto.customer.CustomerRegistrationRequestDto;
import mvp.pioneer.backend.dto.customer.CustomerAuthResponseDto;
import mvp.pioneer.backend.dto.entity.ServiceDto;
import mvp.pioneer.backend.dto.entity.ServiceRequestDto;
import mvp.pioneer.backend.dto.entity.WorkDto;
import mvp.pioneer.backend.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    Person toPerson(CustomerRegistrationRequestDto customerRegistrationRequestDto);

    CustomerAuthResponseDto toCustomerAuthResponseDto(Customer customer);

    ServiceDto toServiceDto(Service service);

    WorkDto toWorkDto(Work work);

    GetAddressesResponseDto toGetAddressesResponseDto(Address address);

    ServiceRequest toServiceRequest(ServiceRequestDto serviceRequestDto);

    ServiceRequestDto toServiceRequestDto(ServiceRequest serviceRequest);

    List<ServiceDto> toServiceDtoList(List<Service> services);

    List<WorkDto> toWorkDtoList(List<Work> works);

    List<GetAddressesResponseDto> toGetAddressesResponseDtoList(List<Address> addresses);
}