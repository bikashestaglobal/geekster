package com.geekster.onlineshopping.service;

import com.geekster.onlineshopping.dao.AddressRepository;
import com.geekster.onlineshopping.dao.UserRepository;
import com.geekster.onlineshopping.model.Address;
import com.geekster.onlineshopping.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    // getAllAddress
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    // getAddressById
    public Address getAddressById(int id){
        return addressRepository.findById(id).get();
    }

    // createAddress
    public Address createAddress(String reqAddress){
        JSONObject jsonAddress = new JSONObject(reqAddress);
        Address address = new Address();
        address.setId(0);
        address.setName(jsonAddress.getString("name"));
        address.setLandmark(jsonAddress.getString("landmark"));
        address.setPhoneNumber(jsonAddress.getString("phoneNumber"));
        address.setZipcode(jsonAddress.getString("zipcode"));
        address.setState(jsonAddress.getString("state"));

        User user = userRepository.findById(jsonAddress.getInt("user")).get();
        address.setUser(user);
        return addressRepository.save(address);
    }

    // updateAddress
    public Address updateAddress(int id, Address reqAddress){
        Address address = getAddressById(id);
        address.setName(reqAddress.getName());
        address.setLandmark(reqAddress.getLandmark());
        address.setPhoneNumber(reqAddress.getPhoneNumber());
        address.setZipcode(reqAddress.getZipcode());
        address.setState(reqAddress.getState());
        return addressRepository.save(address);
    }

    // deleteAddress
    public void deleteAddress(int id){
        addressRepository.deleteById(id);
    }

}
