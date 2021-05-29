package com.eden.shop.search.service;

import com.eden.shop.search.viewmodel.ProductVM;

import java.util.List;

/**
 * Interface {ProductService}
 *
 * @author nvhien
 */
public interface ProductService {

    /**
     * Find all products.
     *
     * @return list of all products
     */
    List<ProductVM> findAllProducts();

    /**
     * Index a product in elasticsearch.
     *
     * @param productVM product to index
     */
    void indexProduct(ProductVM productVM);

    void removeIndex(Long productId);

    void removeAllIndices();
}
