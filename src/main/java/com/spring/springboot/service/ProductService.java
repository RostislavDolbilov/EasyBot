package com.spring.springboot.service;

import com.spring.springboot.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService {
    public Product saveProduct(Product product);
    public Product updateProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductByIdentifier(Long identifier);
}
