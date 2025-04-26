package com.bridgelabz.StockPortfolio.service;

import com.bridgelabz.StockPortfolio.dtos.UserDto;
import org.springframework.http.ResponseEntity;

public interface IUserService {
     ResponseEntity<?> saveUser(UserDto user);
}
