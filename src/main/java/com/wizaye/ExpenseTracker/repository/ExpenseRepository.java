package com.wizaye.ExpenseTracker.repository;

import com.wizaye.ExpenseTracker.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
public interface ExpenseRepository extends MongoRepository<Expense, UUID> {
}
