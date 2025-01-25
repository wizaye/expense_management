package com.wizaye.ExpenseTracker.repository;

import com.wizaye.ExpenseTracker.models.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface BudgetRepository extends MongoRepository<Budget, UUID> {
    List<Budget> findByUserId(UUID userId);
}
