package com.spring.springboot.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@EqualsAndHashCode
public class Product {
    private Long identifier;
    private String productType;
    private String seriesNumber;
    private String manufacturer;
    private int quantity;
    private Settings additionSettings;
}
