package com.spring.springboot.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Product {
    private Long identifier;
    private String productType;
    private String seriesNumber;
    private String manufacturer;
    private int quantity;
    private String additionSettings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getQuantity() != product.getQuantity()) return false;
        if (!getIdentifier().equals(product.getIdentifier())) return false;
        if (!getProductType().equals(product.getProductType())) return false;
        if (!getSeriesNumber().equals(product.getSeriesNumber())) return false;
        if (!getManufacturer().equals(product.getManufacturer())) return false;
        return getAdditionSettings().equals(product.getAdditionSettings());
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
