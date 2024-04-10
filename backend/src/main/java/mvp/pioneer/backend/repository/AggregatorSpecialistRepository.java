package mvp.pioneer.backend.repository;

import mvp.pioneer.backend.entity.AggregatorSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AggregatorSpecialistRepository extends JpaRepository<AggregatorSpecialist, UUID> {

    Optional<AggregatorSpecialist> findBySpecialist_Email(String email);
}
