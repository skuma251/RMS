package com.rms.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableController {

    @GetMapping("/getTables")
    public String getAllTables() {
        return "Here are all the table details";
    }

}
