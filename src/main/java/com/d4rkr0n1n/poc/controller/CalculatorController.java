package com.d4rkr0n1n.poc.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4rkr0n1n.poc.service.CalculatorService;

@RestController
@RequestMapping("/api/v1/calculate")
public class CalculatorController {

  private final CalculatorService calculatorService;

  public CalculatorController(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  @GetMapping("/time")
  public Map<String, Object> getTime() {
    return calculatorService.getTime();
  }

}
