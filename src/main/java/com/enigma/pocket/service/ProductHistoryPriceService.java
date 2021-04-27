package com.enigma.pocket.service;

import com.enigma.pocket.entity.ProductHistoryPrice;

import java.util.List;

public interface ProductHistoryPriceService {

    ProductHistoryPrice logPrice(ProductHistoryPrice productHistoryPrice);
    List<ProductHistoryPrice> findAllPrice();
    List<ProductHistoryPrice> findAllByProduct(String id);

}
