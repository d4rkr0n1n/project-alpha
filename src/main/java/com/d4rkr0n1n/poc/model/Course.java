package com.d4rkr0n1n.poc.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public record Course(
    @Id UUID id,
    String name,
    UUID studentId) {

}
