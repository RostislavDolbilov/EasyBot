package com.spring.springboot.service;

import com.spring.springboot.entity.UserEntity;
import com.spring.springboot.exeption.UserAlreadyExistExeption;
import com.spring.springboot.exeption.UserNotFoundExeption;
import com.spring.springboot.model.User;
import com.spring.springboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registration(UserEntity user) throws UserAlreadyExistExeption {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistExeption("User already exist");
        }
        userRepo.save(user);
    }

    public User getUserById(Long id) throws UserNotFoundExeption {
        UserEntity user = userRepo.findById(id).orElse(null);
        if (user == null){
            throw new UserNotFoundExeption("User with " + id + " - not found");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
