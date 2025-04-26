package com.bridgelabz.StockPortfolio.service;

import com.bridgelabz.StockPortfolio.dtos.HoldingDto;
import com.bridgelabz.StockPortfolio.dtos.PortFolioResponseDto;
import com.bridgelabz.StockPortfolio.models.Holding;
import com.bridgelabz.StockPortfolio.models.User;
import com.bridgelabz.StockPortfolio.repository.HoldingRepository;
import com.bridgelabz.StockPortfolio.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class HoldingServiceImpl implements IHoldingService{
    @Autowired
    private HoldingRepository holdingRepository;
    @Autowired
    private UserRepository userRepository;

    public HoldingServiceImpl(HoldingRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }

    @Override
    public PortFolioResponseDto createHolding(HoldingDto dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        log.info(user.getName());

        Holding newHolding = new Holding(dto);
        newHolding.setUser(user);

        List<Holding> holdings = user.getStockHoldings();
        double value=0;

        //so we are calculating the value
        for(Holding h : holdings){
            value += (h.getCurrentPrice() - h.getBuyPrice()) * h.getQuantity();
        }

        newHolding.setGainOrLoss(value);
        holdingRepository.save(newHolding);
        return new PortFolioResponseDto(holdings,value);
    }
}
