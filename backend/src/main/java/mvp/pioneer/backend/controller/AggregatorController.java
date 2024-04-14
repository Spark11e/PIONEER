package mvp.pioneer.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Авторизация специалиста", description = "Авторизация специалиста-агрегатора, обрабатывающего заявки организаций")
    public AggregatorAuthResponseDto login(@RequestBody AggregatorLoginRequestDto requestDto) {
        return aggregatorFacade.login(requestDto);
    }

    @GetMapping("connection-request")
    @Operation(summary = "Получение заявок", description = "Получения списка заявок на регистрацию от организаций")
    public List<ConnectionRequestDto> getConnectionRequests() {
        return aggregatorFacade.getConnectionRequests();
    }

    @PatchMapping("/connection-request/{id}")
    @Operation(summary = "Обновление заявки", description = "Обновление данных заявки по идентификатору")
    public ConnectionRequestDto patchConnectionRequest(@PathVariable(name = "id") UUID id, @RequestBody PatchConnectionRequestRequestDto requestDto) {
        return aggregatorFacade.patchConnectionRequest(id, requestDto);
    }
}
