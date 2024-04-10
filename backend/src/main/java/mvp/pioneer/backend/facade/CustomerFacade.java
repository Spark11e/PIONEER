package mvp.pioneer.backend.facade;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.dto.customer.CustomerAuthResponseDto;
import mvp.pioneer.backend.dto.customer.CustomerLoginRequestDto;
import mvp.pioneer.backend.dto.customer.CustomerRegistrationRequestDto;
import mvp.pioneer.backend.dto.customer.GetAddressesResponseDto;
import mvp.pioneer.backend.dto.entity.ServiceDto;
import mvp.pioneer.backend.dto.entity.WorkDto;
import mvp.pioneer.backend.entity.ServiceRequest;
import mvp.pioneer.backend.mapper.CustomerMapper;
import mvp.pioneer.backend.producer.ServiceRequestProducer;
import mvp.pioneer.backend.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerFacade {
    private final CustomerService customerService;
    private final ServiceRequestProducer producer;

    private final CustomerMapper customerMapper;

    public CustomerAuthResponseDto registration(CustomerRegistrationRequestDto requestDto) {
        return customerMapper.toCustomerAuthResponseDto(customerService.registration(customerMapper.toPerson(requestDto)));
    }

    public List<ServiceDto> getServices() {
        return customerMapper.toServiceDtoList(customerService.getServices());
    }

    public List<WorkDto> getWorks(UUID serviceId) {
        return customerMapper.toWorkDtoList(customerService.getWorks(serviceId));
    }

    public ServiceRequest createServiceRequest(ServiceRequest requestDto) {
        ServiceRequest request = customerService.createServiceRequest(requestDto);
        producer.sendServiceRequest(request);
        return request;
    }

    public CustomerAuthResponseDto login(CustomerLoginRequestDto requestDto) {
        return customerMapper.toCustomerAuthResponseDto(customerService.login(requestDto.email(), requestDto.password()));
    }

    public List<GetAddressesResponseDto> getAddresses() {
        return customerMapper.toGetAddressesResponseDtoList(customerService.getAddresses());
    }
}
