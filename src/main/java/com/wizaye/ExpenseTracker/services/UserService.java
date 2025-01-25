package com.wizaye.ExpenseTracker.services;

import com.wizaye.ExpenseTracker.models.User;
import com.wizaye.ExpenseTracker.repository.IncomeRepository;
import com.wizaye.ExpenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IncomeRepository incomeRepository;


    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User updateUserById(String userId, User user){
        UUID parsedUserId = UUID.fromString(userId);
        if(userRepository.existsById(parsedUserId)){
            user.setId(parsedUserId);
            return userRepository.save(user);
        }
        return null;
    }
    public boolean deleteUserById(String userId){
        UUID parsedUserId = UUID.fromString(userId);
        if(userRepository.existsById(parsedUserId)){
            userRepository.deleteById(parsedUserId);
            incomeRepository.deleteByUserId(parsedUserId);
            return true;
        }
        return false;
    }

}
