package com.spring.springboot.dal.converter;

import com.spring.springboot.dal.ProductDto;
import com.spring.springboot.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDtoConverter implements Converter<Product, ProductDto> {
    @Override
    public ProductDto convert(Product product) {
        return ProductDto.builder()
                .seriesNumber(product.getSeriesNumber())
                .identifier(product.getIdentifier())
                .productType(product.getProductType())
                .manufacturer(product.getManufacturer())
                .quantity(product.getQuantity())
                .additionSettings(product.getAdditionSettings())
                .build();
    }
}
