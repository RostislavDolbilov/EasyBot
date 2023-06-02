package com.spring.springboot.dal.converter;

import com.spring.springboot.dal.ProductDto;
import com.spring.springboot.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToProductConverter implements Converter<ProductDto, Product> {
    @Override
    public Product convert(ProductDto productDto) {
        return Product.builder()
                .seriesNumber(productDto.getSeriesNumber())
                .identifier(productDto.getIdentifier())
                .productType(productDto.getProductType())
                .manufacturer(productDto.getManufacturer())
                .quantity(productDto.getQuantity())
                .additionSettings(productDto.getAdditionSettings())
                .build();
    }
}
