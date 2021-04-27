package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.entity.PurchaseDetail;
import com.enigma.pocket.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    PocketService pocketService;

    @Override
    public Purchase purchase(Purchase purchase, String customerId) {
        customerService.validateCustomer(customerId);
        Customer customer = customerService.findCustomerById(customerId);
        purchase.setCustomer(customer);
        purchase.setPurchaseDate(new Date(System.currentTimeMillis()));
        // Membeli / Buy
        if (purchase.getPurchaseType().equals(0)) {
            for (PurchaseDetail purchaseDetail : purchase.getPurchaseDetails()) {
                buyProduct(purchase, purchaseDetail);
            }
        // Menjual / Sell
        } else if (purchase.getPurchaseType().equals(1)) {
            for (PurchaseDetail purchaseDetail : purchase.getPurchaseDetails()) {
                checkMinimumSell(purchase, purchaseDetail);
            }
        }
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findPurchaseById(String id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public Page<Purchase> findAllPurchase(Pageable pageable) {
        return purchaseRepository.findAll(pageable);
    }

    private void buyProduct(Purchase purchase, PurchaseDetail purchaseDetail) {
        Pocket pocket = pocketService.findPocketById(purchaseDetail.getPocket().getId());
        pocketService.topUp(pocket.getId(), purchaseDetail.getQuantityInGram());
        purchaseDetail.setProduct(pocket.getProduct());
        purchaseDetail.setPrice(pocket.getProduct().getProductPriceSell());
        purchaseDetail.setPurchase(purchase);
    }

    private void checkMinimumSell(Purchase purchase, PurchaseDetail purchaseDetail) {
        Double purchaseQty = purchaseDetail.getQuantityInGram();
        Pocket pocket = pocketService.findPocketById(purchaseDetail.getPocket().getId());
        Double pocketQty = pocket.getPocketQty();
        if (pocketQty - purchaseQty >= 0) {
            pocketService.sellOff(pocket.getId(), purchaseQty);
            purchaseDetail.setProduct(pocket.getProduct());
            purchaseDetail.setPrice(pocket.getProduct().getProductPriceBuy());
            purchaseDetail.setPurchase(purchase);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You're reaching the minimum quantity to sell, please input the right amount");
        }
    }
}
