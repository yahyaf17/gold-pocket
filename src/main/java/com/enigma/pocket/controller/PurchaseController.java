package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.service.PurchaseService;
import com.enigma.pocket.wrapper.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/purchase")
    public Purchase purchase(@RequestParam (name = "customerId") String customerId,
                             @RequestBody Purchase purchase) {
        return purchaseService.purchase(purchase, customerId);
    }

    @GetMapping("/purchases")
    public PageWrapper<Purchase> getAllPurchase(@RequestParam (name = "page", defaultValue = "0") Integer page,
                                                @RequestParam (name = "size", defaultValue = "5") Integer size,
                                                @RequestParam (name = "sort", defaultValue = "purchaseDate") String sortBy,
                                                @RequestParam (name = "direction", defaultValue = "ASC") Sort.Direction direction) {
        Pageable  pageable = PageRequest.of(page, size, Sort.by(direction,sortBy));
        Page<Purchase> productPage = purchaseService.findAllPurchase(pageable);
        return new PageWrapper<Purchase>(productPage);

    }


}
