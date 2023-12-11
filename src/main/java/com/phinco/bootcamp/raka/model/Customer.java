package com.phinco.bootcamp.raka.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="customers")
@Entity
public class Customer {
    @Id
    String id;
    String name;
    LocalDate birthDate;
    boolean status;
    Timestamp createdDate;
    Timestamp updatedDate;

}
