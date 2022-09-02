package com.workmentor.api.services;

import com.workmentor.api.models.User;
import com.workmentor.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService( UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User AddNewUser(User user){
        return userRepository.save(user);
    }

    public List<User> GetAllUsers(){
        return userRepository.findAll();
    }

    public User GetUserById(String id){
        return userRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public User UpdateUser(User user){
        return userRepository.save(user);
    }

    public boolean DeleteUser(User user){
        userRepository.delete(user);
        return true;
    }
}
