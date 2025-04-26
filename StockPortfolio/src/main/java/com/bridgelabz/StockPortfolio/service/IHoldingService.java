package com.bridgelabz.StockPortfolio.service;


import com.bridgelabz.StockPortfolio.dtos.HoldingDto;
import com.bridgelabz.StockPortfolio.dtos.PortFolioResponseDto;
import org.springframework.http.ResponseEntity;

public interface IHoldingService {
    PortFolioResponseDto createHolding(HoldingDto dto);
}