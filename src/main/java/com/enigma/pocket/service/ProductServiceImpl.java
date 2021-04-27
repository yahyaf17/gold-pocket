package com.enigma.pocket.service;

import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import com.enigma.pocket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Page<Product> searchProduct(Pageable pageable) {
        return (Page<Product>) productRepository.findAll(pageable);
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreatedDate(new Date());
        product.setUpdatedDate(new Date());
        Product savedProduct = productRepository.save(product);
        ProductHistoryPrice productHistoryPrice = new ProductHistoryPrice(savedProduct);
        productHistoryPriceService.logPrice(productHistoryPrice);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        product.setCreatedDate(product.getCreatedDate());
        product.setUpdatedDate(new Date());
        Product savedProduct = productRepository.save(product);
        ProductHistoryPrice productHistoryPrice = new ProductHistoryPrice(savedProduct);
        productHistoryPriceService.logPrice(productHistoryPrice);
        return savedProduct;
    }

//    private Product persistProduct(Product product) {
//        product.setUpdatedDate(new Date());
//        Product savedProduct = productRepository.save(product);
//        ProductHistoryPrice productHistoryPrice = new ProductHistoryPrice(savedProduct);
//        productHistoryPriceService.logPrice(productHistoryPrice);
//        return savedProduct;
//    }

}
