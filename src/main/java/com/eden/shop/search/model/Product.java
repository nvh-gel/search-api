package com.eden.shop.search.model;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.index.VersionType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Product
 *
 * @author nvhien
 */
@Document(indexName = "product", versionType = VersionType.EXTERNAL)
@Getter
@Setter
public class Product {

    @Id
    private Long id;
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
