package mvp.pioneer.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "aggregator_specialist")
public class AggregatorSpecialist extends AbstractEntity {
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Person specialist;

    @ManyToMany(mappedBy = "aggregatorSpecialists", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<ConnectionRequest> connectionRequests = new LinkedHashSet<>();

}