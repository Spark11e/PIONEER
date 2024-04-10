package mvp.pioneer.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mvp.pioneer.backend.enums.ConnectionRequestStatus;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "connection_request")
public class ConnectionRequest extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ConnectionRequestStatus status;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "date_begin", nullable = false)
    private LocalDate dateBegin;

    @Column(name = "reg_number", nullable = false, length = 20)
    private String regNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "connection_request_aggregatorSpecialists",
            joinColumns = @JoinColumn(name = "connectionRequest_id"),
            inverseJoinColumns = @JoinColumn(name = "aggregatorSpecialists_id"))
    private Set<AggregatorSpecialist> aggregatorSpecialists = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

}