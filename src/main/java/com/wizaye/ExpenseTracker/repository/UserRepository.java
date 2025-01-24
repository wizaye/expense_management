package com.wizaye.ExpenseTracker.repository;

import com.wizaye.ExpenseTracker.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
}
