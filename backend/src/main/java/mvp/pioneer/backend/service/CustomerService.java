package mvp.pioneer.backend.service;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.entity.*;
import mvp.pioneer.backend.producer.ServiceRequestProducer;
import mvp.pioneer.backend.repository.AddressRepository;
import mvp.pioneer.backend.repository.CustomerRepository;
import mvp.pioneer.backend.repository.ServiceRepository;
import mvp.pioneer.backend.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;
    private final WorkRepository workRepository;
    private final AddressRepository addressRepository;
    public Customer registration(Person person) {
        return customerRepository.save(new Customer(person));
    }

    public List<mvp.pioneer.backend.entity.Service> getServices() {
        return serviceRepository.findAll();
    }

    public List<Work> getWorks(UUID serviceId) {
        return workRepository.findByServiceId(serviceId);
    }

    public ServiceRequest createServiceRequest(ServiceRequest request) {
        request.setId(UUID.randomUUID());
        return request;
    }

    public List<Address> getAddresses() {
        return addressRepository.findByOrganization_IsConnectedTrue();
    }

    public Customer login(String email, String password) {
        Optional<Customer> optional = customerRepository.findByCustomer_Email(email);
        if (optional.isEmpty()) return null;
        Customer customer = optional.get();
        if (password.equals(customer.getCustomer().getPassword())) return customer;
        else return null;
    }
}
