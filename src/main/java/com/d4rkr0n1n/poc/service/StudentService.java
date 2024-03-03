package com.d4rkr0n1n.poc.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.d4rkr0n1n.poc.model.Student;

import lombok.extern.java.Log;

@Service
@Log
public class StudentService {
  public static Student testService() {
    Student student = new Student(UUID.randomUUID(),"John Doe", "Doe", null, null, null);
    log.info(Integer.toString(student.hashCode()));
    log.info(student.toString());
    return student;
  }
  private StudentService() {
  }
}
