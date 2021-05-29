package com.eden.shop.search.mapper;

import com.eden.shop.search.model.Product;
import com.eden.shop.search.viewmodel.ProductVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
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

    @Mapping(target = "id", ignore = true)
    Product productVMToProduct(ProductVM productVM);

    @Mapping(target = "id", ignore = true)
    void mapUpdateProduct(@MappingTarget Product product, ProductVM productVM);
}
