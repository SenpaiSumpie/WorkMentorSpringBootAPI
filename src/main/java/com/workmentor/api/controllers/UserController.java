package com.workmentor.api.controllers;

import com.workmentor.api.models.User;
import com.workmentor.api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController( UserService userService ){
        this.userService = userService;
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping("/{id}")
    public User GetUser(@PathVariable String id){
        return userService.GetUserById(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping
    public List<User> GetAllUsers(){
        return userService.GetAllUsers();
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @PostMapping
    public User PostUser(@RequestBody User user){
        return userService.AddNewUser(user);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @PutMapping
    public ResponseEntity<User> PutUser(@RequestBody User user){
        User foundUser = userService.GetUserById(user.getId().toString());
        if(foundUser != null){
            User updatedUser = userService.UpdateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteUser(@RequestBody User user){
        User foundUser = userService.GetUserById(user.getId().toString());
        if(foundUser != null){
            userService.DeleteUser(user);
            return new ResponseEntity<>("Deleted User", HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping("/test")
    public String TestUserEndpoint(){
        return "UserController: Test Success!";
    }
}
