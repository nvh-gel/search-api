package com.eden.shop.search.controller;

import com.eden.shop.search.service.ProductService;
import com.eden.shop.search.utils.MessageFormatter;
import com.eden.shop.search.utils.ResponseCode;
import com.eden.shop.search.utils.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 *
 * @author nvhien
 */
@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService productService;
    private MessageFormatter messageFormatter;

    /**
     * Find all products.
     *
     * @return list of all products
     */
    @GetMapping
    public ResponseEntity<ResponseModel> findAllProducts() {

        var responseModel = ResponseModel.formatResponse(ResponseCode.SUCCESS);
        responseModel.setMessage(messageFormatter.formatMessage(responseModel.getMessage()));
        responseModel.setData(productService.findAllProducts());
        return ResponseEntity.ok(responseModel);
    }

    /**
     * Setter.
     */
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Setter.
     */
    @Autowired
    public void setMessageFormatter(MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }
}
