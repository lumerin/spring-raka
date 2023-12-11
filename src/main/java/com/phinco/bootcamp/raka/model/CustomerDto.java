package com.phinco.bootcamp.raka.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDto {
    @NotBlank
    String id;
    String name;
    LocalDate birthDate;
}
