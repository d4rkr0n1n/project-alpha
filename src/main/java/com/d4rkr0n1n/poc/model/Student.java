package com.d4rkr0n1n.poc.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public record Student(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id,
    String name,
    String email,
    String city,
    String course,
    String rollNumber) {
}
