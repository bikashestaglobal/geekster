package com.geekster.onlineshopping.controller;

import com.geekster.onlineshopping.model.Address;
import com.geekster.onlineshopping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
    @Autowired
    AddressService addressService;

    // getAllAddress
    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    // getAddressById
    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable int id){
        return addressService.getAddressById(id);
    }

    // createAddress
    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    // updateAddress
    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable int id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }

    // deleteAddress
    @DeleteMapping("/address/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Address deleted successfully", HttpStatus.OK);
    }
}
