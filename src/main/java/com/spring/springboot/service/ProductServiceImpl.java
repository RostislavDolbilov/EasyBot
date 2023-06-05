package com.spring.springboot.service;

import com.spring.springboot.dal.ProductDto;
import com.spring.springboot.model.Product;
import com.spring.springboot.model.filter.SettingsFilter;
import com.spring.springboot.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;
    private final ConversionService conversionService;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ConversionService conversionService) {
        this.productRepo = productRepo;
        this.conversionService = conversionService;
    }

    @Override
    public ProductDto saveProduct(ProductDto product) {
        if (getBySeriesNumber(product.getSeriesNumber()) != null){
            log.error("This product already exists!");
        }else {
            productRepo.save(product);
            log.info("New product with identifier: {}, was saved!", product.getId());
        }
        return  product;
    }

    @Override
    public ProductDto getBySeriesNumber(String seriesNumber) {
        return productRepo.findBySeriesNumber(seriesNumber);
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {
        productRepo.save(product);
        log.info("Product with identifier: {}, was updated!", product.getId());
        return product;
    }


    @Override
    public List<Product> getAllProductsByProductType(String productType) {
        List<Product> products = new ArrayList<>();
        List<ProductDto> productsDto = productRepo.findAll().stream()
                .filter(product -> (product.getProductType().name()).equals(productType))
                .collect(Collectors.toList());

        for (ProductDto p: productsDto) {
            Product product = conversionService.convert(p, Product.class);
            assert product != null;
            product.setAdditionSettings(SettingsFilter
                    .getSettings(p.getProductType(), p.getSettings()));
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getProductByIdentifier(Long identifier) {
        ProductDto productDto = productRepo.getById(identifier);
        if (productDto != null){
            Product product = conversionService.convert(productDto, Product.class);
            assert product != null;
            product.setAdditionSettings(SettingsFilter
                    .getSettings(productDto.getProductType(), productDto.getSettings()));
            return product;
        }else {
            log.error("Product with identifier: {}, not found!", identifier);
            return null;
        }
    }
}
