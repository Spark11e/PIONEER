package mvp.pioneer.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.dto.customer.CustomerAuthResponseDto;
import mvp.pioneer.backend.dto.customer.CustomerLoginRequestDto;
import mvp.pioneer.backend.dto.customer.CustomerRegistrationRequestDto;
import mvp.pioneer.backend.dto.customer.GetAddressesResponseDto;
import mvp.pioneer.backend.dto.entity.ServiceDto;
import mvp.pioneer.backend.dto.entity.WorkDto;
import mvp.pioneer.backend.entity.ServiceRequest;
import mvp.pioneer.backend.facade.CustomerFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@RestController(value = "customer-controller")
public class CustomerController {
    private final CustomerFacade facade;

    @Operation(summary = "Регистрация потребителя", description = "Регистрация нового потребителя")
    @PostMapping("/registration")
    public CustomerAuthResponseDto registration(@RequestBody CustomerRegistrationRequestDto requestDto) {
        return facade.registration(requestDto);
    }

    @Operation(summary = "Авторизация потребителя", description = "Авторизация потребителя по электронной почте и паролю")
    @PostMapping("/login")
    public CustomerAuthResponseDto login(@RequestBody CustomerLoginRequestDto requestDto) {
        return facade.login(requestDto);
    }

    @Operation(summary = "Получение услуг", description = "Получение списка услуг (мойка/шиномонтаж)")
    @GetMapping("/services")
    public List<ServiceDto> getServices() {
        return facade.getServices();
    }

    @Operation(summary = "Получение аддресов", description = "Получение списка адрессов всех организаций")
    @GetMapping("/addresses")
    public List<GetAddressesResponseDto> getAddresses() {
        return facade.getAddresses();
    }

    @Operation(summary = "Получение работ", description = "Получение списка работ по идентификатору услуги (помыть салон/замена шин)")
    @GetMapping("/works")
    public List<WorkDto> getWorks(@RequestParam(value = "serviceId", defaultValue = "402586b5-1bd5-42f5-a2d2-c9fb760a02b5") UUID serviceId) {
        return facade.getWorks(serviceId);
    }

    @Operation(summary = "Создание заявки", description = "Создание заявки на выполнение организацией услуг")
    @PostMapping("/service-request")
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest requestDto) {
        return facade.createServiceRequest(requestDto);
    }
}
