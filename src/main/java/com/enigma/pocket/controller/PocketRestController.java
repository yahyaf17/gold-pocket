package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PocketRestController {

    @Autowired
    PocketService pocketService;

    @GetMapping("/pocket/{id}")
    public Pocket findPocketDetail(@PathVariable (name = "id") String id) {
        return pocketService.findPocketById(id);
    }

    @PostMapping("/pocket")
    public Pocket createNewProduct (@RequestBody Pocket pocket) {
        return pocketService.createNewPocket(pocket);
    }

    @GetMapping("/customer/{id}/pocket")
    public List<Pocket> findCustomerPocket(@PathVariable(name = "id") String customerId) {
        return pocketService.findAllByCustomer(customerId);
    }

}
