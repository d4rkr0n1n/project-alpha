package com.d4rkr0n1n.poc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.d4rkr0n1n.poc.model.Student;
import com.d4rkr0n1n.poc.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {

  @GetMapping("/test")
  public Student test() {
    return StudentService.testService();
  }

}
