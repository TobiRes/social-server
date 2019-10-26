package com.social.server.controller;

import java.util.List;

import com.social.server.converter.ProjectDTOToProjectConverter;
import com.social.server.converter.UserDTOToUserConcerter;
import com.social.server.models.project.Project;
import com.social.server.models.project.ProjectDTO;
import com.social.server.models.user.User;
import com.social.server.models.user.UserDTO;
import com.social.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
public class UserController{

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/usr/register", 
    produces = {"application/json"}, 
    method = RequestMethod.POST) 
    public ResponseEntity<User> createUser(@RequestBody UserDTO body) {

        User newUser = UserDTOToUserConcerter.converter(body);
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }


    @RequestMapping(value="/usr/login",
    produces = {"application/json"},
    method = RequestMethod.POST)
    public ResponseEntity<User> getSingleUserById(@RequestBody UserDTO loginUser){
        
        
        List<User> userList = userRepository.findAll();

        User foundUser = null;
        for(User temp : userList){
            if(temp.getUsername().equals(loginUser.getUsername())){
                foundUser = temp;
            }
        }

        return new ResponseEntity<>(foundUser, HttpStatus.BAD_REQUEST);
    }
}

