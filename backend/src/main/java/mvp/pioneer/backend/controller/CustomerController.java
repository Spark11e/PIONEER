package mvp.pioneer.backend.controller;

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

    @PostMapping("/registration")
    public CustomerAuthResponseDto registration(@RequestBody CustomerRegistrationRequestDto requestDto) {
        return facade.registration(requestDto);
    }

    @PostMapping("/login")
    public CustomerAuthResponseDto login(@RequestBody CustomerLoginRequestDto requestDto) {
        return facade.login(requestDto);
    }

    @GetMapping("/services")
    public List<ServiceDto> getServices() {
        return facade.getServices();
    }

    @GetMapping("/addresses")
    public List<GetAddressesResponseDto> getAddresses() {
        return facade.getAddresses();
    }

    @GetMapping("/works")
    public List<WorkDto> getWorks(@RequestParam(value = "serviceId", defaultValue = "402586b5-1bd5-42f5-a2d2-c9fb760a02b5") UUID serviceId) {
        return facade.getWorks(serviceId);
    }

    @PostMapping("/service-request")
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest requestDto) {
        return facade.createServiceRequest(requestDto);
    }
}
