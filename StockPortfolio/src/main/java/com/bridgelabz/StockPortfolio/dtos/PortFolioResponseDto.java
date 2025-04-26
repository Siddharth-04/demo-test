package com.bridgelabz.StockPortfolio.dtos;

import com.bridgelabz.StockPortfolio.models.Holding;
import lombok.Data;

import java.util.List;

@Data
public class PortFolioResponseDto {
    List<Holding> stockHolding;
    Double value;

    public PortFolioResponseDto(List<Holding> holdings, double value) {
        this.stockHolding = holdings;
        this.value =  value;
    }
}
