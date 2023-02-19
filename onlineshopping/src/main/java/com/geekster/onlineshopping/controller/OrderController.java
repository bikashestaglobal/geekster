package com.geekster.onlineshopping.controller;

import com.geekster.onlineshopping.model.Order;
import com.geekster.onlineshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderService orderService;

    // getAllOrders
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    // getOrderById
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }

    // createOrder
    @PostMapping("/orders")
    public Order createOrder(@RequestBody String reqOrder){
        return orderService.createOrder(reqOrder);
    }

    // deleteOrder
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Order Deleted", HttpStatus.OK);

    }

}
