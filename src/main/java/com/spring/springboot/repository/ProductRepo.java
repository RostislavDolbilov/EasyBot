package com.spring.springboot.repository;

import com.spring.springboot.dal.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<ProductDto, Long> {
    ProductDto findBySeriesNumber(String seriesNumber);
}
