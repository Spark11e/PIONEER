package mvp.pioneer.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "work")
public class Work extends AbstractEntity {
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "cost", nullable = false, precision = 19, scale = 2)
    @JdbcTypeCode(SqlTypes.DECIMAL)
    private BigDecimal cost;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

}