package mvp.pioneer.backend.mapper;

import mvp.pioneer.backend.dto.customer.CustomerAuthResponseDto;
import mvp.pioneer.backend.dto.customer.CustomerRegistrationRequestDto;
import mvp.pioneer.backend.dto.customer.GetAddressesResponseDto;
import mvp.pioneer.backend.dto.entity.ServiceDto;
import mvp.pioneer.backend.dto.entity.WorkDto;
import mvp.pioneer.backend.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "patronymic", target = "patronymic")
    Person toPerson(CustomerRegistrationRequestDto customerRegistrationRequestDto);

    @Mapping(source = "customer.email", target = "email")
    @Mapping(source = "customer.phoneNumber", target = "phoneNumber")
    @Mapping(source = "customer.name", target = "name")
    @Mapping(source = "customer.surname", target = "surname")
    @Mapping(source = "customer.patronymic", target = "patronymic")
    CustomerAuthResponseDto toCustomerAuthResponseDto(Customer customer);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "code", target = "code")
    ServiceDto toServiceDto(Service service);

    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "cost", target = "cost")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "code", target = "code")
    WorkDto toWorkDto(Work work);

    @Mapping(source = "id", target = "addressId")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "houseNumber", target = "houseNumber")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "organization.id", target = "organizationId")
    @Mapping(source = "organization.shortName", target = "shortName")
    @Mapping(source = "organization.fullName", target = "fullName")
    GetAddressesResponseDto toGetAddressesResponseDto(Address address);


    List<ServiceDto> toServiceDtoList(List<Service> services);

    List<WorkDto> toWorkDtoList(List<Work> works);

    List<GetAddressesResponseDto> toGetAddressesResponseDtoList(List<Address> addresses);
}