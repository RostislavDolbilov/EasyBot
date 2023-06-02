package com.spring.springboot.controller;

import com.spring.springboot.model.Product;
import com.spring.springboot.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name="ProductController", description="Creation of new products, updating and getting")
public class ProductsController {
    private final ProductService productsService;

    @Autowired
    public ProductsController(ProductService productsService) {
        this.productsService = productsService;
    }


    @PostMapping("/add_product")
    @Operation( summary = "Save product",
                description = "Creation the new product")
    public Product saveProduct(@RequestBody @Parameter(description = "Product body") Product product){
        return productsService.saveProduct(product);
    }

    @PutMapping("/update_product")
    @Operation( summary = "Update product",
                description = "Updating the product")
    public Product updateProduct(@RequestBody @Parameter(description = "Product body") Product product) {
        return productsService.updateProduct(product);
    }

    @GetMapping("/get_product")
    @Operation( summary = "Getting product by identifier",
                description = "Getting product by identifier")
    public Product findProductById(@RequestParam @Parameter(description = "Product identifier") Long identifier){
        return productsService.getProductByIdentifier(identifier);
    }

    @GetMapping("/get_all_products")
    @Operation( summary = "Find all products",
            description = "Getting all products")
    public List<Product> findAllProducts(){
        return productsService.getAllProducts();
    }
}
