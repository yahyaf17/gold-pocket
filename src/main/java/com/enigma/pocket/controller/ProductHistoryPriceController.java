package com.enigma.pocket.controller;

import com.enigma.pocket.entity.ProductHistoryPrice;
import com.enigma.pocket.service.ProductHistoryPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
public class ProductHistoryPriceController {

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    //Find All History
    @GetMapping("/priceHistories")
    public List<ProductHistoryPrice> getAllHistory() {
        return productHistoryPriceService.findAllPrice();
    }

}
