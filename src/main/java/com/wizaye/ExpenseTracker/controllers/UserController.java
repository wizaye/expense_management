package com.wizaye.ExpenseTracker.controllers;

import com.wizaye.ExpenseTracker.models.User;
import com.wizaye.ExpenseTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) throws Exception{
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody User user) throws Exception{
        return new ResponseEntity<>(userService.updateUserById(userId,user),HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.deleteUserById(userId),HttpStatus.OK);
    }
}

// if user is deleted and his userId is given to fetch incomes default behaviour should be user doesnt exist
// delete user gives 500 error with userId

// Expense, Budget

