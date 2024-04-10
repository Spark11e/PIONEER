package mvp.pioneer.backend.mapper;

import mvp.pioneer.backend.dto.entity.AddressDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.dto.entity.OrganizationDto;
import mvp.pioneer.backend.dto.entity.PersonDto;
import mvp.pioneer.backend.entity.Address;
import mvp.pioneer.backend.entity.ConnectionRequest;
import mvp.pioneer.backend.entity.Organization;
import mvp.pioneer.backend.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationMapper {

    @Mapping(source = "ogrn", target = "ogrn")
    @Mapping(source = "kpp", target = "kpp")
    @Mapping(source = "inn", target = "inn")
    @Mapping(source = "shortName", target = "shortName")
    @Mapping(source = "fullName", target = "fullName")
    Organization toOrganization(OrganizationDto requestDto);

    @Mapping(source = "ogrn", target = "ogrn")
    @Mapping(source = "kpp", target = "kpp")
    @Mapping(source = "inn", target = "inn")
    @Mapping(source = "shortName", target = "shortName")
    @Mapping(source = "fullName", target = "fullName")
    OrganizationDto toOrganizationDto(Organization organization);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "dateEnd", target = "dateEnd")
    @Mapping(source = "dateBegin", target = "dateBegin")
    @Mapping(source = "regNumber", target = "regNumber")
    ConnectionRequestDto toConnectionRequestDto(ConnectionRequest connectionRequest);

    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "houseNumber", target = "houseNumber")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "addressType", target = "addressType")
    AddressDto toAddressDto(Address address);

    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "houseNumber", target = "houseNumber")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "addressType", target = "addressType")
    Address toAddress(AddressDto addressDto);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "patronymic", target = "patronymic")
    PersonDto toPersonDto(Person person);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "patronymic", target = "patronymic")
    Person toPerson(PersonDto person);

    List<AddressDto> toAddressDtoList(List<Address> addresses);

    List<ConnectionRequestDto> toConnectionRequestDtoList(List<ConnectionRequest> connectionRequests);
}