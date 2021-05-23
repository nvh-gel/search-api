package com.eden.shop.search.repository;

import com.eden.shop.search.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Interface {ProductRepository}
 *
 * @author nvhien
 */
public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

}
