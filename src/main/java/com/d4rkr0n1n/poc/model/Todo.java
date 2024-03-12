package com.d4rkr0n1n.poc.model;

import java.time.LocalDate;

public record Todo(
    int id,
    String username,
    String description,
    LocalDate targetDate,
    boolean done) {
}
