package com.spring.springboot.service;

import com.spring.springboot.dal.ProductDto;
import com.spring.springboot.model.Product;
import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto product);
    ProductDto updateProduct(ProductDto product);
    ProductDto getBySeriesNumber(String seriesNumber);
    List<Product> getAllProductsByProductType(String productType);
    Product getProductByIdentifier(Long identifier);
}
