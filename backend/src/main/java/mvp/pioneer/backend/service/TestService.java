package mvp.pioneer.backend.service;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.entity.*;
import mvp.pioneer.backend.repository.CustomerRepository;
import mvp.pioneer.backend.repository.OrganizationRepository;
import mvp.pioneer.backend.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {
    private final CustomerRepository customerRepository;
    private final OrganizationRepository organizationRepository;
    private final WorkRepository workRepository;

    public ServiceRequest createServiceRequest() {
        Customer customer = customerRepository.findAll().get(0);
        Organization organization = organizationRepository.findAll().get(0);
        List<UUID> works = workRepository.findAll().stream().map(AbstractEntity::getId).collect(Collectors.toList());
        return new ServiceRequest(UUID.randomUUID(), customer.getId(), organization.getId(), LocalDateTime.now(), works);
    }
}
