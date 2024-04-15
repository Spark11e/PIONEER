package mvp.pioneer.backend.mapper;

import mvp.pioneer.backend.dto.aggregator.AggregatorAuthResponseDto;
import mvp.pioneer.backend.dto.aggregator.AggregatorSpecialistDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.dto.entity.OrganizationDto;
import mvp.pioneer.backend.entity.AggregatorSpecialist;
import mvp.pioneer.backend.entity.ConnectionRequest;
import mvp.pioneer.backend.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface AggregatorMapper {

    @Mapping(source = "specialist.id", target = "id")
    @Mapping(source = "specialist.email", target = "email")
    @Mapping(source = "specialist.phoneNumber", target = "phoneNumber")
    @Mapping(source = "specialist.name", target = "name")
    @Mapping(source = "specialist.surname", target = "surname")
    @Mapping(source = "specialist.patronymic", target = "patronymic")
    AggregatorSpecialistDto toAggregatorSpecialistDto(AggregatorSpecialist person);

    @Mapping(source = "id", target = "id")
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

    List<ConnectionRequestDto> toConnectionRequestDtoList(List<ConnectionRequest> connectionRequests);


    @Mapping(source = "specialist.email", target = "email")
    @Mapping(source = "specialist.phoneNumber", target = "phoneNumber")
    @Mapping(source = "specialist.name", target = "name")
    @Mapping(source = "specialist.surname", target = "surname")
    @Mapping(source = "specialist.patronymic", target = "patronymic")
    AggregatorAuthResponseDto toAggregatorAuthResponseDto(AggregatorSpecialist aggregatorSpecialist);
}
