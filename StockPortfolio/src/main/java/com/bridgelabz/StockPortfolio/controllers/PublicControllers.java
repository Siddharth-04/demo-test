package com.bridgelabz.StockPortfolio.controllers;

import com.bridgelabz.StockPortfolio.dtos.UserDto;
import com.bridgelabz.StockPortfolio.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/")
public class PublicControllers {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("create-user")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user){
        return userService.saveUser(user);
    }
}
