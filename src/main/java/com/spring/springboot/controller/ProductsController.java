package com.spring.springboot.controller;

import com.spring.springboot.dal.ProductDto;
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
    public ProductDto saveProduct(@RequestBody @Parameter(description = "Product body") ProductDto product){
        return productsService.saveProduct(product);
    }

    @PutMapping("/update_product")
    @Operation( summary = "Update product",
                description = "Updating the product")
    public ProductDto updateProduct(@RequestBody @Parameter(description = "Product body with id fields") ProductDto product) {
        return productsService.updateProduct(product);
    }

    @GetMapping("/get_product")
    @Operation( summary = "Getting product by identifier",
                description = "Getting product by identifier")
    public Product findProductById(@RequestParam @Parameter(description = "Product id") Long identifier){
        return productsService.getProductByIdentifier(identifier);
    }

    @GetMapping("/get_all/product_type")
    @Operation( summary = "Find all products by product type",
            description = "Getting all products by product type")
    public List<Product> findAllProducts(@RequestParam
                                             @Parameter(description = "Product type. LAPTOP, PERSONAL_PC, MONITOR or HARD_DISK")
                                                     String productType){
        return productsService.getAllProductsByProductType(productType);
    }
}
