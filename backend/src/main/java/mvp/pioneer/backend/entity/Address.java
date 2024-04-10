package mvp.pioneer.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mvp.pioneer.backend.enums.AddressType;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address extends AbstractEntity {
    @Column(name = "subject", nullable = false, length = 50)
    private String subject;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "house_number", nullable = false, length = 10)
    private String houseNumber;

    @Column(name = "street", nullable = false, length = 50)
    private String street;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", nullable = false, length = 30)
    private AddressType addressType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Organization organization;

}