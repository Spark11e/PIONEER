package mvp.pioneer.backend.repository;

import mvp.pioneer.backend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    List<Address> findByOrganization_IsConnectedTrue();

    List<Address> findByOrganization_Id(UUID id);
}