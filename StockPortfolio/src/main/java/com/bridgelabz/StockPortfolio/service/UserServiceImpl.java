package com.bridgelabz.StockPortfolio.service;

import com.bridgelabz.StockPortfolio.dtos.UserDto;
import com.bridgelabz.StockPortfolio.models.User;
import com.bridgelabz.StockPortfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> saveUser(UserDto user) {
        User newUser = new User(user);
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
