package com.eden.shop.search.service.impl;

import com.eden.shop.search.mapper.ProductMapper;
import com.eden.shop.search.repository.ProductRepository;
import com.eden.shop.search.service.ProductService;
import com.eden.shop.search.viewmodel.ProductVM;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * ProductServiceImpl
 *
 * @author nvhien
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductVM> findAllProducts() {

        var products = StreamSupport
                .stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return productMapper.productToProductVM(products);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void indexProduct(ProductVM productVM) {

        var product = productRepository.findProductByProductId(productVM.getProductId());
        if (null != product) {
            productMapper.mapUpdateProduct(product, productVM);
        } else {
            product = productMapper.productVMToProduct(productVM);
        }
        productRepository.save(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeIndex(Long productId) {

        var product = productRepository.findProductByProductId(productId);
        if (null != product) {
            productRepository.delete(product);
        }
    }

    @Override
    public void removeAllIndices() {

        productRepository.deleteAll();
    }

    /**
     * Setter.
     */
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
