package com.d4rkr0n1n.poc.service;

import org.springframework.stereotype.Service;

import com.d4rkr0n1n.poc.model.Student;

@Service
public class StudentService {
  public static Student testService() {
    Student student = new Student("John Doe", "Doe", null, null, null);
    System.out.println(student.hashCode());
    System.out.println(student.toString());
    return student;
  }
}
