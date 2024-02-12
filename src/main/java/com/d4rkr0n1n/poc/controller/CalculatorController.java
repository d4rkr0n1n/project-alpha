package com.d4rkr0n1n.poc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4rkr0n1n.poc.service.CalculatorService;

@RestController
@RequestMapping("/api/v1/calculate")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/time")
    public HashMap<String,Object> getTime() {
       
        return calculatorService.getTime();
    }

}
