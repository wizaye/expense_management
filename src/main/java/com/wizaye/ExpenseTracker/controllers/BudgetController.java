package com.wizaye.ExpenseTracker.controllers;

import com.wizaye.ExpenseTracker.models.Budget;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {
    @GetMapping("/getBudgets/{userId}")
    public List<Budget> getBudgets() {
        return null;
    }
    @PostMapping("/addBudget/{userId}")
    public boolean addBudget(@PathVariable String userId, @RequestBody Budget budget) {
        return false;
    }

    @PutMapping("/updateBudget/{budgetId}")
    public boolean updateBudget(@PathVariable String budgetId, @RequestBody Budget budget) {
        return false;
    }

    @DeleteMapping("/deleteBudget/{budgetId}")
    public boolean deleteBudget(@PathVariable String budgetId) {
        return false;
    }

}
