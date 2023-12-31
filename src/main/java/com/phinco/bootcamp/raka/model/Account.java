package com.phinco.bootcamp.raka.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="accounts")
@Entity
public class Account {
    @Id
    String id;
    String name;
    String type;
    String customerId;
    Long amount;
    boolean status;
    Timestamp createdDate;
    Timestamp updatedDate;

}
