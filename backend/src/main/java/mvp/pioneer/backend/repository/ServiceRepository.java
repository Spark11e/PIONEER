package mvp.pioneer.backend.repository;

import mvp.pioneer.backend.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {
}
