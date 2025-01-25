package com.wizaye.ExpenseTracker.services;

import com.wizaye.ExpenseTracker.models.Budget;
import com.wizaye.ExpenseTracker.models.User;
import com.wizaye.ExpenseTracker.repository.BudgetRepository;
import com.wizaye.ExpenseTracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    public BudgetService(BudgetRepository budgetRepository, UserRepository userRepository) {
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
    }
    public List<Budget> getAllBudget(String userId) {
        UUID parsedUserId = UUID.fromString(userId);
        return budgetRepository.findByUserId(parsedUserId);
    }
    public Budget getBudgetById(String budgetId) {
        UUID parsedBudgetId = UUID.fromString(budgetId);
        return budgetRepository.findById(parsedBudgetId).orElse(null);
    }
    public Budget addBudget(String userId,Budget budget) {
        UUID parsedUserId = UUID.fromString(userId);
        Optional<User> userOptional=userRepository.findById(parsedUserId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            budget.setUser_id(parsedUserId);
            Budget savedBudget=budgetRepository.save(budget);
            user.getUser_budget().add(savedBudget.getId());
            userRepository.save(userOptional.get());
            return savedBudget;
        }
        return null;
    }
    public Budget updateBudget(String userId,String budgetId,Budget budget) {
        UUID parsedUserId = UUID.fromString(userId);
        UUID parsedBudgetId = UUID.fromString(budgetId);
        Optional<User> userOptional=userRepository.findById(parsedUserId);
        if(userOptional.isPresent() && userOptional.get().getUser_budget().contains(parsedBudgetId)) {
            budget.setUser_id(parsedUserId);
            budget.setId(parsedBudgetId);
            return budgetRepository.save(budget);
        }
        return null;
    }
    public boolean deleteBudget(String userId,String budgetId) {
        UUID parsedUserId = UUID.fromString(userId);
        UUID parsedBudgetId = UUID.fromString(budgetId);
        Optional<User> userOptional=userRepository.findById(parsedUserId);
        if(userOptional.isPresent() && userOptional.get().getUser_budget().contains(parsedBudgetId)) {
            budgetRepository.deleteById(parsedBudgetId);
            userOptional.get().getUser_budget().remove(parsedBudgetId);
            userRepository.save(userOptional.get());
            return true;
        }
        return false;
    }
}
