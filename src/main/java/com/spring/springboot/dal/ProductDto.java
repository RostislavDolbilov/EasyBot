package com.spring.springboot.dal;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.springboot.model.ProductType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@SuperBuilder
@Builder
public class ProductDto extends AbstractIdentificationEntity{

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "series_number")
    private String seriesNumber;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "quantity")
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonManagedReference
    private SettingsDto settings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductDto that = (ProductDto) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
