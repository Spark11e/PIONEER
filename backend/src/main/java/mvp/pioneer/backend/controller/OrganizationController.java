package mvp.pioneer.backend.controller;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.dto.entity.AddressDto;
import mvp.pioneer.backend.dto.entity.OrganizationDto;
import mvp.pioneer.backend.dto.entity.ServiceRequestDto;
import mvp.pioneer.backend.dto.entity.ConnectionRequestDto;
import mvp.pioneer.backend.dto.organization.OrganizationLoginRequestDto;
import mvp.pioneer.backend.dto.organization.OrganizationRegistrationRequestDto;
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
    public OrganizationDto registration(@RequestBody OrganizationRegistrationRequestDto requestDto) {
        return facade.registration(requestDto);
    }

    @GetMapping("/addresses/{id}")
    public List<AddressDto> getAddresses(@PathVariable UUID id) {
        return facade.getAddresses(id);
    }

    @PutMapping("/addresses")
    public AddressDto putAddress(@RequestBody AddressDto addressDto) {
        return facade.putAddress(addressDto);
    }

    @PostMapping("/login")
    public OrganizationDto login(@RequestBody OrganizationLoginRequestDto requestDto) {
        return facade.login(requestDto);
    }

    @GetMapping("/connection-request/{id}")
    public List<ConnectionRequestDto> getConnectionRequests(@PathVariable UUID id) {
        return facade.getConnectionRequests(id);
    }

    @GetMapping("/service-request/{id}")
    public ServiceRequestDto getServiceRequest(@PathVariable UUID id) {
        return facade.getServiceRequest(id);
    }
}
