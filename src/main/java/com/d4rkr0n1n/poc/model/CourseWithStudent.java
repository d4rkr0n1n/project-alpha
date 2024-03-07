package com.d4rkr0n1n.poc.model;

import java.util.UUID;
import java.util.List;

import org.springframework.data.annotation.Id;

public record CourseWithStudent(
    @Id UUID id,
    String name,
    List<Student> students) {

}
