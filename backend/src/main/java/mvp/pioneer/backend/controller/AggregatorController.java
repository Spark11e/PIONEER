package mvp.pioneer.backend.controller;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.dto.aggregator.AggregatorAuthResponseDto;
import mvp.pioneer.backend.dto.aggregator.AggregatorLoginRequestDto;
import mvp.pioneer.backend.dto.aggregator.PatchConnectionRequestRequestDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.facade.AggregatorFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController("aggregator-controller")
@RequestMapping("/api/v1/aggregator")
public class AggregatorController {

    private final AggregatorFacade aggregatorFacade;

    @PostMapping("/login")
    public AggregatorAuthResponseDto login(@RequestBody AggregatorLoginRequestDto requestDto){
        return aggregatorFacade.login(requestDto);
    }

    @GetMapping("connection-request")
    public List<ConnectionRequestDto> getConnectionRequests(){
        return aggregatorFacade.getConnectionRequests();
    }

    @PatchMapping("/connection-request/{id}")
    public ConnectionRequestDto patchConnectionRequest(@PathVariable UUID id, @RequestBody PatchConnectionRequestRequestDto requestDto){
        return aggregatorFacade.patchConnectionRequest(id, requestDto);
    }
}
