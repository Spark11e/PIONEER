package mvp.pioneer.backend.repository;

import mvp.pioneer.backend.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    Optional<Organization> findByResponsiblePerson_Email(String email);
}