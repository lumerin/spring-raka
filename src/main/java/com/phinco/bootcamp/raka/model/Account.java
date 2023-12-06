package com.phinco.bootcamp.raka.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Account {
    @Id
    int id;
    String name;
    double amount;

    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public String setIdString() {
        return String.valueOf(id);
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

}
