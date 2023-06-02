package com.spring.springboot.service;

import com.spring.springboot.dal.ProductDto;
import com.spring.springboot.model.Product;
import com.spring.springboot.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public Product saveProduct(Product product) {
        if (getProductByIdentifier(product.getIdentifier()) != null){
            log.error("This product already exists!");
            return  new Product();
        }else {
            productRepo.save(Objects.requireNonNull(conversionService.convert(product, ProductDto.class)));
            log.info("New product with identifier: {}, was saved!", product.getIdentifier());
            return product;
        }
    }

    @Override
    public Product updateProduct(Product product) {
        Product productForUpdate = getProductByIdentifier(product.getIdentifier());
        productForUpdate.setProductType(product.getProductType());
        productForUpdate.setManufacturer(product.getManufacturer());
        productForUpdate.setQuantity(product.getQuantity());
        productForUpdate.setSeriesNumber(product.getSeriesNumber());
        productForUpdate.setAdditionSettings(product.getAdditionSettings());

        productRepo.save(Objects.requireNonNull(conversionService.convert(productForUpdate, ProductDto.class)));
        log.info("Product with identifier: {}, was updated!", product.getIdentifier());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return StreamSupport.stream(productRepo.findAll().spliterator(), false)
                .map(productDto -> conversionService.convert(productDto, Product.class))
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductByIdentifier(Long identifier) {
        Optional<ProductDto> productDto = productRepo.findById(identifier);
        if(productDto.isPresent()){
            return conversionService.convert(productDto.get(), Product.class);
        }else {
            log.error("Product with identifier: {}, not found!", identifier);
            return new Product();
        }
    }
}
