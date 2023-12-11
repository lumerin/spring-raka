package com.phinco.bootcamp.raka.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Data
public class AccountDto {
    @NotBlank(message = "id mandatory")
    String id;
    String name;
    String type;
    String customerId;
    Long amount;
}
