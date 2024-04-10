package mvp.pioneer.backend.mapper;

import mvp.pioneer.backend.dto.aggregator.AggregatorAuthResponseDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.entity.AggregatorSpecialist;
import mvp.pioneer.backend.entity.ConnectionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {OrganizationMapper.class})

public interface AggregatorMapper {

    List<ConnectionRequestDto> toConnectionRequestDtoList(List<ConnectionRequest> connectionRequests);

    ConnectionRequestDto toConnectionRequestDto(ConnectionRequest connectionRequest);

    @Mapping(source = "specialist.email", target = "email")
    @Mapping(source = "specialist.phoneNumber", target = "phoneNumber")
    @Mapping(source = "specialist.name", target = "name")
    @Mapping(source = "specialist.surname", target = "surname")
    @Mapping(source = "specialist.patronymic", target = "patronymic")
    AggregatorAuthResponseDto toAggregatorAuthResponseDto(AggregatorSpecialist aggregatorSpecialist);
}
