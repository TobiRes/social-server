package com.social.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.social.server.converter.ProjectDTOToProjectConverter;
import com.social.server.converter.UserDTOToUserConcerter;
import com.social.server.models.project.Project;
import com.social.server.models.project.ProjectDTO;
import com.social.server.models.user.User;
import com.social.server.models.user.UserDTO;
import com.social.server.repositories.ProjectRepository;
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
    private ProjectRepository projectRepository;

    @Autowired
    public UserController(UserRepository userRepository, ProjectRepository projectRepository){
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
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

    @RequestMapping(value="/usr/join/{user}",
    produces = {"application/json"},
    method = RequestMethod.GET)
    public ResponseEntity<User> joinProject(@PathVariable("user") String userName, @RequestParam(value = "projectname") String projectName){

        List<User> userList = userRepository.findAll();
        List<Project> projectList = projectRepository.findAll();

        User currentUser = null; 
        Project currentProject = null;

        for(User temp : userList){
            if(temp.getUsername().equals(userName)){
                currentUser = temp;
            }
        }

        
        for(Project temp : projectList){
            if(temp.getTitle().equals(projectName)){
                currentProject = temp;
                if(temp.getUsers() == null){break;}
                List<User> activeUsers = new ArrayList<>(temp.getUsers());
                activeUsers.add(currentUser);
                temp.setUsers(activeUsers);
                projectRepository.save(temp);
            }
        }

        List<Project> activeProjects = new ArrayList<>(currentUser.getActiveProjects());
        //currentUser.getActiveProjects().add(currentProject);
        activeProjects.add(currentProject);
        currentUser.setActiveProjects(activeProjects);
        userRepository.save(currentUser);



        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }


    @RequestMapping(value="/usr/projects/{username}",
    produces = {"application/json"},
    method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getProjects(@PathVariable("username") String userName){

       
        List<User> userList = userRepository.findAll();

        User currentUser = null; 

        for(User temp : userList){
            if(temp.getUsername().equals(userName)){
                currentUser = temp;
            }
        }

        return new ResponseEntity<>(currentUser.getActiveProjects(), HttpStatus.OK);
    }



}

