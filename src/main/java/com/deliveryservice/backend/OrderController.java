package com.deliveryservice.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gunupur")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderdetails/{id}")
    public OrderDetailsResponse getOrderDetails(@PathVariable Integer id) {
        return orderService.getFullOrderDetails(id);
    }
}