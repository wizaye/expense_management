package com.wizaye.ExpenseTracker.services;

import com.wizaye.ExpenseTracker.models.Expense;
import com.wizaye.ExpenseTracker.models.User;
import com.wizaye.ExpenseTracker.repository.ExpenseRepository;
import com.wizaye.ExpenseTracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public List<Expense> getExpenses(String userId) {
        UUID parsedUserId = UUID.fromString(userId);
        return expenseRepository.findByUserId(parsedUserId);
    }
    public Expense getExpense(UUID expenseId) {
        if(expenseRepository.existsById(expenseId)) {
            return expenseRepository.findById(expenseId).orElse(null);
        }
        return null;
    }
    public Expense addExpense(String userId,Expense expense){
        UUID parsedUserId = UUID.fromString(userId);
        Optional<User> userOptional = userRepository.findById(parsedUserId);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            expense.setUserId(parsedUserId);
            Expense savedExpense = expenseRepository.save(expense);
            user.getUser_expenses().add(savedExpense.getId());
            userRepository.save(user);
            return savedExpense;
        }
        return null;
    }
    public Expense updateExpense(String userId,String expenseId,Expense expense){
        UUID parsedUserId = UUID.fromString(userId);
        UUID parsedExpenseId = UUID.fromString(expenseId);
        Optional<User> userOptional = userRepository.findById(parsedUserId);
        if(userOptional.isPresent() && userOptional.get().getUser_expenses().contains(parsedExpenseId)) {
            expense.setUserId(parsedUserId);
            expense.setId(parsedExpenseId);
            return expenseRepository.save(expense);
        }
        return null;
    }
    public boolean deleteExpense(String userId,String expenseId) {
        UUID parsedUserId = UUID.fromString(userId);
        UUID parsedExpenseId = UUID.fromString(expenseId);
        Optional<User> userOptional = userRepository.findById(parsedUserId);
        if(userOptional.isPresent() && userOptional.get().getUser_expenses().contains(parsedExpenseId)) {
            userRepository.deleteById(parsedUserId);
            userOptional.get().getUser_expenses().remove(parsedExpenseId);
            userRepository.save(userOptional.get());
            return true;
        }
        return false;
    }

}
