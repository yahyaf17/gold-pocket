package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PocketServiceImpl implements PocketService{

    @Autowired
    PocketRepository pocketRepository;

    @Autowired
    CustomerService customerService;

    private final String notFoundMessage = "Pocket with id: %s Not Found!";

    @Override
    public Pocket findPocketById(String id) {
        validatePocket(id);
        return pocketRepository.findById(id).get();
    }

    @Override
    public Pocket createNewPocket(Pocket pocket) {
        pocket.setPocketQty(0.0);
        return pocketRepository.save(pocket);
    }

    @Override
    public void updatePocket(Pocket pocket) {
        validatePocket(pocket.getId());
        pocketRepository.save(pocket);
    }

    @Override
    public void topUp(String id, Double qty) {
        validatePocket(id);
        Pocket pocket = findPocketById(id);
        pocket.setPocketQty(pocket.getPocketQty() + qty);
        pocketRepository.save(pocket);
    }

    @Override
    public void sellOff(String id, Double qty) {
        validatePocket(id);
        Pocket pocket = findPocketById(id);
        pocket.setPocketQty(pocket.getPocketQty() - qty);
        pocketRepository.save(pocket);
    }

    @Override
    public List<Pocket> findAllByCustomer(String customerId) {
        customerService.validateCustomer(customerId);
        Customer customer = customerService.findCustomerById(customerId);
        return customer.getPocketList();
    }

    @Override
    public void deleteById(String id) {
        validatePocket(id);
        pocketRepository.deleteById(id);
    }

    private void validatePocket(String id) {
        if(!(pocketRepository.findById(id).isPresent())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }
}
