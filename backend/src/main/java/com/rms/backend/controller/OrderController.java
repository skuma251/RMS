package com.rms.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("getMyOrders")
    public String getMyOrders() {
        return "Here is your order history";
    }

}
