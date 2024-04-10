package mvp.pioneer.backend.repository;

import mvp.pioneer.backend.entity.Service;
import mvp.pioneer.backend.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkRepository extends JpaRepository<Work, UUID> {
    List<Work> findByServiceId(UUID serviceId);
}