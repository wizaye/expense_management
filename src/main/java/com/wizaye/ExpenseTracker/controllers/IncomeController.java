package com.wizaye.ExpenseTracker.controllers;

import com.wizaye.ExpenseTracker.models.Income;
import com.wizaye.ExpenseTracker.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @GetMapping("/allIncomes/{userId}")
    public ResponseEntity<?> allIncomesById(@PathVariable String userId) {
       return new ResponseEntity<>(incomeService.getIncomesByUser(userId), HttpStatus.OK);
    }
    @PostMapping("/addIncome/{userId}")
    public ResponseEntity<?> addIncomeById(@PathVariable String userId, @RequestBody Income income) {
        return new ResponseEntity<>(incomeService.addIncome(userId,income), HttpStatus.OK);
    }
    @PutMapping("/updateIncome/{userId}/{incomeId}")
    public ResponseEntity<?> updateIncomeById(@PathVariable String userId,@PathVariable String incomeId, @RequestBody Income income) {
        return new ResponseEntity<>(incomeService.updateIncome(userId,incomeId,income), HttpStatus.OK);
    }
    @DeleteMapping("/deleteIncome/{userId}/{incomeId}")
    public ResponseEntity<?> deleteIncomeById(@PathVariable String userId, @PathVariable String incomeId) {
        return new ResponseEntity<>(incomeService.deleteIncome(userId,incomeId), HttpStatus.OK);
    }
}
