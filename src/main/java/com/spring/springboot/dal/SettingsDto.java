package com.spring.springboot.dal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "settings")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@SuperBuilder
@Builder
public class SettingsDto extends AbstractIdentificationEntity{

    @Column(name = "diagonal")
    private String diagonal;

    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "memory_capacity")
    private String memoryCapacity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductDto product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SettingsDto that = (SettingsDto) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
