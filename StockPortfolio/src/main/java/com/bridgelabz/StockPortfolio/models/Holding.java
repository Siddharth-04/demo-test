package com.bridgelabz.StockPortfolio.models;

import com.bridgelabz.StockPortfolio.dtos.HoldingDto;
import com.bridgelabz.StockPortfolio.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Holding {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String symbol;
    private int quantity;
    private double buyPrice;
    private double currentPrice;
    private double gainOrLoss;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Holding(HoldingDto dto){
        updateHolding(dto);
    }

    public Holding() {

    }

    private void updateHolding(HoldingDto dto) {
        this.setSymbol(dto.getSymbol());
        this.setQuantity(dto.getQuantity());
        this.setBuyPrice(dto.getBuyPrice());
        this.setCurrentPrice(dto.getCurrentPrice());
    }
}
