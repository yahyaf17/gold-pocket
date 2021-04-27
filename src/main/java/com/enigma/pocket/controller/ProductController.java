package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import com.enigma.pocket.service.ProductHistoryPriceService;
import com.enigma.pocket.service.ProductService;
import com.enigma.pocket.wrapper.PageWrapper;
import com.enigma.pocket.wrapper.WrapperMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(name = "id") String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    public PageWrapper<Product> getAllProduct(@RequestParam (name = "page", defaultValue = "0") Integer page,
                                              @RequestParam (name = "size", defaultValue = "5") Integer size,
                                              @RequestParam (name = "sort", defaultValue = "productName") String sortBy,
                                              @RequestParam (name = "direction", defaultValue = "ASC") Sort.Direction direction) {
        Pageable  pageable = PageRequest.of(page, size, Sort.by(direction,sortBy));
        Page<Product> productPage = productService.searchProduct(pageable);
        return new PageWrapper<Product>(productPage);
    }

    @PostMapping("/product")
    public ResponseEntity<WrapperMessage> createProduct(@RequestBody Product product) {
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.accepted().body(WrapperMessage.commonResponse(202, newProduct));
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/product/{id}/history")
    public List<ProductHistoryPrice> getAllHistoryByProduct(@PathVariable (name = "id") String id) {
        return productHistoryPriceService.findAllByProduct(id);
    }

}
