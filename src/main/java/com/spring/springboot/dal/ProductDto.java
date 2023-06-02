package com.spring.springboot.dal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class ProductDto {
    @Id
    @JsonProperty(required = true)
    @JsonPropertyDescription("The unique product ID")
    @Column(name = "identifier")
    private Long identifier;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The type of product")
    @Column(name = "product_type")
    private String productType;

    @Column(name = "series_number")
    @JsonProperty(required = true)
    @JsonPropertyDescription("The product series number")
    private String seriesNumber;

    @Column(name = "manufacturer")
    @JsonProperty(required = true)
    @JsonPropertyDescription("The product manufacturer")
    private String manufacturer;

    @Column(name = "quantity")
    @JsonProperty(required = true)
    @JsonPropertyDescription("The quantity of products")
    private int quantity;

    @Column(name = "addition_settings")
    @JsonProperty(required = true)
    @JsonPropertyDescription("The additional settings fot product")
    private String additionSettings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;

        ProductDto that = (ProductDto) o;

        if (getQuantity() != that.getQuantity()) return false;
        if (!getIdentifier().equals(that.getIdentifier())) return false;
        if (!getProductType().equals(that.getProductType())) return false;
        if (!getSeriesNumber().equals(that.getSeriesNumber())) return false;
        if (!getManufacturer().equals(that.getManufacturer())) return false;
        return getAdditionSettings().equals(that.getAdditionSettings());
    }

    @Override
    public int hashCode() {
        int result = getIdentifier().hashCode();
        result = 31 * result + getProductType().hashCode();
        result = 31 * result + getSeriesNumber().hashCode();
        result = 31 * result + getManufacturer().hashCode();
        result = 31 * result + getQuantity();
        result = 31 * result + getAdditionSettings().hashCode();
        return result;
    }
}
