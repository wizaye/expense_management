package com.wizaye.ExpenseTracker.services;

import com.wizaye.ExpenseTracker.models.Income;
import com.wizaye.ExpenseTracker.models.User;
import com.wizaye.ExpenseTracker.repository.IncomeRepository;
import com.wizaye.ExpenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public List<Income> getIncomesByUser(String userId){
        UUID userUuid = UUID.fromString(userId);
        return incomeRepository.findByUserId(userUuid);

    }
    public Income addIncome(String userId,Income income){
        UUID parsedId = UUID.fromString(userId);
        Optional<User> userOptional = userRepository.findById(parsedId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            income.setUserId(parsedId);
            Income savedIncome = incomeRepository.save(income);
            user.getUser_income().add(savedIncome.getId());
            userRepository.save(user);
            return savedIncome;
        }
        return null;
    }
    public Income updateIncome(String userId,String incomeId,Income income){
        UUID parsedUserId = UUID.fromString(userId);
        UUID parsedIncomeId = UUID.fromString(incomeId);
        Optional<User> userOptional = userRepository.findById(parsedUserId);
        if (userOptional.isPresent() && userOptional.get().getUser_income().contains(parsedIncomeId)) {
            Income savedIncome = incomeRepository.save(income);
            return income;
        }
        return null;
    }
    public boolean deleteIncome(String userId, String incomeId) {
        try {
            // Parse the user and income IDs
            UUID parsedUserId = UUID.fromString(userId);
            UUID parsedIncomeId = UUID.fromString(incomeId);

            // Retrieve the user
            Optional<User> userOptional = userRepository.findById(parsedUserId);

            if (userOptional.isPresent()) {
                User user = userOptional.get();

                // Check if the income is associated with the user
                if (user.getUser_income().contains(parsedIncomeId)) {
                    // Remove the income ID from the user's income list
                    user.getUser_income().remove(parsedIncomeId);
                    userRepository.save(user); // Persist the updated user

                    // Delete the income record
                    if (incomeRepository.existsById(parsedIncomeId)) {
                        incomeRepository.deleteById(parsedIncomeId);
                    }
                    return true;
                }
            }
            return false;
        } catch (IllegalArgumentException e) {
            // Handle invalid UUID format
            return false;
        } catch (Exception e) {
            // Log unexpected exceptions (optional)
            System.err.println("Error while deleting income: " + e.getMessage());
            return false;
        }
    }

}


