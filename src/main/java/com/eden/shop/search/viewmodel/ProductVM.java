package com.eden.shop.search.viewmodel;

import lombok.Data;

/**
 * ProductVM
 *
 * @author nvhien
 */
@Data
public class ProductVM {

    private Long productId;
    private String productName;
    private String description;
    private Integer brandId;
    private String brandName;
    private Integer categoryId;
    private String categoryName;
    private Double price;
    private Double salePrice;
    private Integer totalStock;
    private Integer activeStock;
    private Integer reservedStock;
    private String cover;
    private String images;
}
