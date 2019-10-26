package com.social.server.controller;

import com.social.server.converter.ProjectDTOToProjectConverter;
import com.social.server.models.project.Project;
import com.social.server.repositories.OrganizationRepository;
import com.social.server.repositories.ProjectRepository;
import com.social.server.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
public class GlobalController{

    private ProjectRepository projectReository;
    private UserRepository userRepository;
    private OrganizationRepository organizationRepository;

    @Autowired
    public GlobalController(ProjectRepository projectReository, UserRepository userRepository, OrganizationRepository organizationRepository){
        this.projectReository = projectReository;
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
    }

    @RequestMapping(value = "/resetdb",
        produces = {"applicatian/json"},
        method = RequestMethod.DELETE)
    public ResponseEntity<Void> delteDataBase(){

        projectReository.deleteAll();
        userRepository.deleteAll();
        organizationRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}