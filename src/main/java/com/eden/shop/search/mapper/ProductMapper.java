package com.eden.shop.search.mapper;

import com.eden.shop.search.model.Product;
import com.eden.shop.search.viewmodel.ProductVM;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * Interface {ProductMapper}
 *
 * @author nvhien
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    ProductVM productToProductVM(Product product);
    List<ProductVM> productToProductVM(List<Product> product);
}
