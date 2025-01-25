package com.wizaye.ExpenseTracker.repository;

import com.wizaye.ExpenseTracker.models.Income;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface IncomeRepository  extends MongoRepository<Income, UUID> {

    List<Income> findByUserId(UUID userUuid);
    boolean deleteByUserId(UUID userUuid);
}
