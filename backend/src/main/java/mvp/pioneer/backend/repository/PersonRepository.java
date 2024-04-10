package mvp.pioneer.backend.repository;

import mvp.pioneer.backend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}