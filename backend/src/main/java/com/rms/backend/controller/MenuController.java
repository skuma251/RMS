package com.rms.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @GetMapping("/getMenu")
    public String getMenuDetails() {
        return "Here are the menu details from the DB";
    }

}
