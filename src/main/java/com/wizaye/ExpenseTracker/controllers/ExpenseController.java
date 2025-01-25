package com.wizaye.ExpenseTracker.controllers;

import com.wizaye.ExpenseTracker.models.Expense;
import com.wizaye.ExpenseTracker.services.ExpenseService;
import com.wizaye.ExpenseTracker.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/getExpenses/{userId}")
    public ResponseEntity<List<Expense>> getExpenses(@PathVariable String userId) {
        return new ResponseEntity<>(expenseService.getExpenses(userId), HttpStatus.OK);
    }

    @PostMapping("/addExpense/{userId}")
    public ResponseEntity<Expense> addExpense(@PathVariable String userId,@RequestBody Expense expense) {
        return new ResponseEntity<>(expenseService.addExpense(userId, expense), HttpStatus.OK);
    }

    @PutMapping("/updateExpense/{userId}/{expenseId}")
    public ResponseEntity<Expense> updateExpense(@PathVariable String userId,@PathVariable String expenseId, @RequestBody Expense expense) {
        return new ResponseEntity<>(expenseService.updateExpense(userId, expenseId, expense), HttpStatus.OK);
    }

    @DeleteMapping("/deleteExpense/{userId}/{expenseId}")
    public ResponseEntity<Boolean> deleteExpense(@PathVariable String userId,@PathVariable String expenseId) {
        return new ResponseEntity<>(expenseService.deleteExpense(userId,expenseId),HttpStatus.OK);
    }
}
