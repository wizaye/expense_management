package com.wizaye.ExpenseTracker.controllers;

import com.wizaye.ExpenseTracker.models.Expense;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @GetMapping("/getExpenses/{userId}")
    public List<Expense> getExpenses() { return null;}

    @PostMapping("/addExpense/{userid}")
    public Expense addExpense(@PathVariable String userId,@RequestBody Expense expense) { return expense;}

    @PutMapping("/updateExpense/{expenseId}")
    public Expense updateExpense(@PathVariable String expenseId, @RequestBody Expense expense) { return expense;}

    @DeleteMapping("/deleteExpense/{expenseId}")
    public boolean deleteExpense(@PathVariable String expenseId) { return expenseId != null;}


}
