package com.enigma.pocket.service;

import com.enigma.pocket.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurchaseService {

    Purchase purchase(Purchase purchase, String id);
    Purchase findPurchaseById(String id);
    Page<Purchase> findAllPurchase(Pageable pageable);

}
