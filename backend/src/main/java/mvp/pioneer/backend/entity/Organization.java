package mvp.pioneer.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "organization")
@ToString
public class Organization extends AbstractEntity {
    @Column(name = "ogrn", nullable = false, length = 13)
    private String ogrn;

    @Column(name = "kpp", nullable = false, length = 9)
    private String kpp;

    @Column(name = "inn", nullable = false, length = 10)
    private String inn;

    @Column(name = "short_name", nullable = false, length = 50)
    private String shortName;

    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @Column(name = "is_connected", nullable = false)
    private boolean isConnected;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Person responsiblePerson;

}