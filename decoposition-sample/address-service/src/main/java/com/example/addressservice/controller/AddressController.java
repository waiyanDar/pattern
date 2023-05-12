package com.example.addressservice.controller;

import com.example.addressservice.dao.AddressDao;
import com.example.addressservice.dto.Addresses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressDao addressDao;

    public AddressController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @GetMapping("/addresses")
    public Addresses listAllAddress(){
        return new Addresses(addressDao.findAll());
    }
}
