package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.UserEntity;
import com.example.Repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserEntity save(UserEntity user) {
        return userRepo.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public Optional<UserEntity> getUserById(int id) {
        return userRepo.findById(id);
    }

    public UserEntity updateUser(int id, UserEntity newUser) {
        Optional<UserEntity> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            existingUser.setUsername(newUser.getUsername());
            existingUser.setContact(newUser.getContact());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setPassword(newUser.getPassword()); // Ensure to update password if needed
            return userRepo.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
