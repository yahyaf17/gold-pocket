package com.enigma.pocket.service;

import com.enigma.pocket.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product getProductById(String id);
    Page<Product> searchProduct(Pageable pageable);
    Product saveProduct(Product product);
    Product updateProduct(Product product);

}
