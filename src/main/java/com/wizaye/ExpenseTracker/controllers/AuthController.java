package com.wizaye.ExpenseTracker.controllers;

import com.wizaye.ExpenseTracker.services.AuthService;
import com.wizaye.ExpenseTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestParam("username") String username,@RequestParam("email") String email, @RequestParam("password") String password) {
        return authService.register(username,email, password);
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestParam("username") String username,@RequestParam("email") String email, @RequestParam("password") String password) {
        return authService.login(username, email, password);
    }

}
