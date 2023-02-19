package com.geekster.onlineshopping.service;

import com.geekster.onlineshopping.dao.AddressRepository;
import com.geekster.onlineshopping.dao.OrderRepository;
import com.geekster.onlineshopping.dao.ProductRepository;
import com.geekster.onlineshopping.dao.UserRepository;
import com.geekster.onlineshopping.model.Address;
import com.geekster.onlineshopping.model.Order;
import com.geekster.onlineshopping.model.Product;
import com.geekster.onlineshopping.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ProductRepository productRepository;

    // getAllOrders
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    // getOrderById
    public Order getOrderById(int id){
        return orderRepository.findById(id).get();
    }

    // createOrder
    public Order createOrder(String reqOrder){
        JSONObject orderJson = new JSONObject((reqOrder));
        Order newOrder = new Order();
        newOrder.setId(0);

        User user = userRepository.findById(orderJson.getInt("user")).get();
        newOrder.setUser(user);

        Address address = addressRepository.findById(orderJson.getInt("address")).get();
        newOrder.setAddress(address);

        Product product = productRepository.findById(orderJson.getInt("product")).get();
        newOrder.setProduct(product);

        newOrder.setProductQuantity(orderJson.getInt("productQuantity"));

        return orderRepository.save(newOrder);
    }

    // deleteOrder
    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }
}
