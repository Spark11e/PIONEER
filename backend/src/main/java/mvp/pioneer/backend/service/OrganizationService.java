package mvp.pioneer.backend.service;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.entity.Address;
import mvp.pioneer.backend.entity.ConnectionRequest;
import mvp.pioneer.backend.entity.Organization;
import mvp.pioneer.backend.entity.ServiceRequest;
import mvp.pioneer.backend.enums.ConnectionRequestStatus;
import mvp.pioneer.backend.repository.AddressRepository;
import mvp.pioneer.backend.repository.ConnectionRequestRepository;
import mvp.pioneer.backend.repository.OrganizationRepository;
import mvp.pioneer.backend.repository.PersonRepository;
import mvp.pioneer.backend.util.ServiceRequestQueue;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final ConnectionRequestRepository connectionRequestRepository;
    private final AddressRepository addressRepository;
    private final ServiceRequestQueue queue;
    private final PersonRepository personRepository;

    public ServiceRequest getServiceRequest(UUID organizationId) {
        return queue.poll(organizationId);
    }

    public Organization registration(Organization organization) {
        organization.setResponsiblePerson(personRepository.save(organization.getResponsiblePerson()));
        return organizationRepository.save(organization);
    }

    public ConnectionRequest sendConnectionRequest(UUID organizationId) {
        ConnectionRequest request = new ConnectionRequest();
        request.setStatus(ConnectionRequestStatus.NEW);
        request.setDateBegin(LocalDate.now());
        request.setRegNumber(UUID.randomUUID().toString().substring(0, 18));
        request.setOrganization(organizationRepository.findById(organizationId).orElseThrow());
        return connectionRequestRepository.save(request);
    }

    public List<ConnectionRequest> getConnectionRequests(UUID organizationId) {
        return connectionRequestRepository.findByOrganization_Id(organizationId);
    }

    public List<Address> getAddresses(UUID organizationId) {
        return addressRepository.findByOrganization_Id(organizationId);
    }

    public Address putAddress(Address address) {
        address.setOrganization(organizationRepository.findById(address.getOrganization().getId()).orElseThrow());
        return addressRepository.save(address);
    }

    public Organization login(String email, String password) {
        Optional<Organization> optional = organizationRepository.findByResponsiblePerson_Email(email);
        if (optional.isEmpty()) return null;
        Organization organization = optional.get();
        if (password.equals(organization.getResponsiblePerson().getPassword())) return organization;
        else return null;
    }
}
