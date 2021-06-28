package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.PurchaseDetail;

import java.util.List;

public interface PocketService {

    Pocket findPocketById(String id);
    Pocket createNewPocket(Pocket pocket);
    void updatePocket(Pocket pocket);
    void topUp(String id, PurchaseDetail purchaseDetail);
    void sellOff(String id, PurchaseDetail purchaseDetail);
    List<Pocket> findAllByCustomer(String customerId);
    void deleteById(String id);

}
