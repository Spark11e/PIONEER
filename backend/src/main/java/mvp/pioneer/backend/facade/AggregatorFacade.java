package mvp.pioneer.backend.facade;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.dto.aggregator.AggregatorAuthResponseDto;
import mvp.pioneer.backend.dto.aggregator.AggregatorLoginRequestDto;
import mvp.pioneer.backend.dto.aggregator.PatchConnectionRequestRequestDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.mapper.AggregatorMapper;
import mvp.pioneer.backend.service.AggregatorService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AggregatorFacade {

    private final AggregatorService aggregatorService;
    private final AggregatorMapper aggregatorMapper;

    public AggregatorAuthResponseDto login(AggregatorLoginRequestDto requestDto) {
        return aggregatorMapper.toAggregatorAuthResponseDto(aggregatorService.login(requestDto.email(), requestDto.password()));
    }

    public List<ConnectionRequestDto> getConnectionRequests() {
        return aggregatorMapper.toConnectionRequestDtoList(aggregatorService.getConnectionRequests());
    }

    public ConnectionRequestDto patchConnectionRequest(UUID id, PatchConnectionRequestRequestDto requestDto) {
        return aggregatorMapper.toConnectionRequestDto(aggregatorService.patchConnectionRequest(id, requestDto.status()));
    }
}
