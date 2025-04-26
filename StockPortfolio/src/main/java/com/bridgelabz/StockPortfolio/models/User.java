package com.bridgelabz.StockPortfolio.models;

import com.bridgelabz.StockPortfolio.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String email;
    String name;
    String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
            @JsonIgnore
    List<Holding> stockHoldings;

    public User(UserDto user){
        updateUser(user);
    }

    public User() {

    }
    
    
    
    private void updateUser(UserDto dto) {
        this.setEmail(dto.getEmail());
        this.setName(dto.getName());
        this.setPassword(dto.getPassword());
        this.stockHoldings = new ArrayList<>();
    }
}
