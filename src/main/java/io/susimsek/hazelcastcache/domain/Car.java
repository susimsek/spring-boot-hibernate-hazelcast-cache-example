package io.susimsek.hazelcastcache.domain;

import io.susimsek.hazelcastcache.domain.audit.AbstractDateAuditingEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "car")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Car extends AbstractDateAuditingEntity implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "car_seq_id", allocationSize = 1)
    @GeneratedValue(generator = "car_seq_id", strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(length = 100)
    String serial;

    @Column(length = 100)
    String model;

    @Column(length = 100)
    String brand;

    Integer year;

    @Column(length = 100, name = "car_type")
    String type;

    int doorCount;

    @Column(length = 100)
    String colour;

    @Column(length = 100)
    String fuel;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        return id != null && id.equals(((Car) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

}
