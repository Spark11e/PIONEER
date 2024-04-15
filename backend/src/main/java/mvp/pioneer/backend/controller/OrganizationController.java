package mvp.pioneer.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.dto.entity.AddressDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.dto.entity.OrganizationDto;
import mvp.pioneer.backend.dto.organization.OrganizationLoginRequestDto;
import mvp.pioneer.backend.dto.organization.OrganizationRegistrationRequestDto;
import mvp.pioneer.backend.entity.ServiceRequest;
import mvp.pioneer.backend.facade.OrganizationFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/organization")
@RestController("organization-controller")
public class OrganizationController {

    private final OrganizationFacade facade;

    @PostMapping("/registration")
    @Operation(summary = "Регистрация организации", description = "Регистрация новой организации")
    public OrganizationDto registration(@RequestBody OrganizationRegistrationRequestDto requestDto) {
        return facade.registration(requestDto);
    }

    @GetMapping("/addresses/{id}")
    @Operation(summary = "Получение аддресов", description = "Получение списка аддресов по идентификатору организации")
    public List<AddressDto> getAddresses(@PathVariable UUID id) {
        return facade.getAddresses(id);
    }

    @PutMapping("/addresses")
    @Operation(summary = "Добавление/обновление аддреса", description = "Добавление нового или обновление уже существующего адресса")
    public AddressDto putAddress(@RequestBody AddressDto addressDto) {
        return facade.putAddress(addressDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Авторизация организации", description = "Авторизация организации по электронной почте и паролю")
    public OrganizationDto login(@RequestBody OrganizationLoginRequestDto requestDto) {
        return facade.login(requestDto);
    }

    @GetMapping("/connection-request/{id}")
    @Operation(summary = "Получение заявок на регистрацию", description = "Получение списка заявок на регистрацию организации по ее идентификатору")
    public List<ConnectionRequestDto> getConnectionRequests(@PathVariable UUID id) {
        return facade.getConnectionRequests(id);
    }

    @PostMapping("/connection-request/{id}")
    @Operation(summary = "Отправка заявки на регистрацию", description = "Отправка заявки на регистрацию организации по ее идентификатору")
    public ConnectionRequestDto sendConnectionRequests(@PathVariable UUID id) {
        return facade.sendConnectionRequests(id);
    }

    @GetMapping("/service-request/{id}")
    @Operation(summary = "Получение заявки на услуги", description = "Получение оставленной заявки на услуги от потребителя по идентификатору организации в порядке LIFO")
    public ServiceRequest getServiceRequest(@PathVariable UUID id) {
        return facade.getServiceRequest(id);
    }
}
