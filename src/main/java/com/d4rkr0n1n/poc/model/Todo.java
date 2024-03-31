package com.d4rkr0n1n.poc.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo{
    int id;
    String username;

    @Min(value = 5, message = "Description should be more than 5 characters")
    String description;
    LocalDate targetDate;
    boolean done;
}
