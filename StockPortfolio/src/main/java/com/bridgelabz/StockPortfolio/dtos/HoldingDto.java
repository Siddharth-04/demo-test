package com.bridgelabz.StockPortfolio.dtos;

import lombok.Data;

@Data
public class HoldingDto {
    String symbol;
    int quantity;
    double buyPrice;
    double currentPrice;
    String email;
}
