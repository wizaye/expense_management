package com.wizaye.ExpenseTracker.repository;

import com.wizaye.ExpenseTracker.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;
public interface ExpenseRepository extends MongoRepository<Expense, UUID> {
    List<Expense> findByUserId(UUID userId);
}
