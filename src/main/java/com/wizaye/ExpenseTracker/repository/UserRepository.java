package com.wizaye.ExpenseTracker.repository;

import com.wizaye.ExpenseTracker.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface UserRepository extends MongoRepository<User, UUID> {
    @Query(value="{'id': ?0}", fields="{'user_income': 1}")
    Optional<List<UUID>> getUserIncomes(UUID userId);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<String> findByUsername(String username);

}
