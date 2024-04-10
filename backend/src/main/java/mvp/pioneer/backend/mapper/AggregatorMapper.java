package mvp.pioneer.backend.mapper;

import mvp.pioneer.backend.dto.aggregator.AggregatorAuthResponseDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.entity.AggregatorSpecialist;
import mvp.pioneer.backend.entity.ConnectionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface AggregatorMapper {

    List<ConnectionRequestDto> toConnectionRequestDtoList(List<ConnectionRequest> connectionRequests);

    ConnectionRequestDto toConnectionRequestDto(ConnectionRequest connectionRequest);

    AggregatorAuthResponseDto toAggregatorAuthResponseDto(AggregatorSpecialist aggregatorSpecialist);
}
