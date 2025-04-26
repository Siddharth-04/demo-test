package com.bridgelabz.StockPortfolio.controllers;

import com.bridgelabz.StockPortfolio.dtos.HoldingDto;
import com.bridgelabz.StockPortfolio.dtos.PortFolioResponseDto;
import com.bridgelabz.StockPortfolio.service.HoldingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holding")
public class HoldingController {

    @Autowired
    HoldingServiceImpl holdingService;

    @PostMapping("create-holding")
    public PortFolioResponseDto createHolding(@RequestBody HoldingDto dto){
        return holdingService.createHolding(dto);
    }
}
