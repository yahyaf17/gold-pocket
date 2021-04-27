package com.enigma.pocket.service;

import com.enigma.pocket.entity.Pocket;

import java.util.List;

public interface PocketService {

    Pocket findPocketById(String id);
    Pocket createNewPocket(Pocket pocket);
    void topUp(String id, Double qty);
    void sellOff(String id, Double qty);
    List<Pocket> findAllByCustomer(String customerId);

}
