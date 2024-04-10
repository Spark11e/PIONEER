package mvp.pioneer.backend.repository;

import mvp.pioneer.backend.entity.ConnectionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConnectionRequestRepository extends JpaRepository<ConnectionRequest, UUID> {
    List<ConnectionRequest> findByOrganization_Id(UUID id);
}