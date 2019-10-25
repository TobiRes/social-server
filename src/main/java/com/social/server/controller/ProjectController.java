package com.social.server.controller;

import com.social.server.converter.ProjectDTOToProjectConverter;
import com.social.server.models.project.Project;
import com.social.server.models.project.ProjectDTO;
import com.social.server.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableAutoConfiguration
@RestController
public class ProjectController {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;

    }

    @RequestMapping(value = "/project",
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Project> createProject(@RequestBody ProjectDTO body) {
        Project newProject = ProjectDTOToProjectConverter.convert(body);
        projectRepository.save(newProject);
        return new ResponseEntity<>(newProject, HttpStatus.OK);
    }

    @RequestMapping(value = "/project/{projectID}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDfdModel(@PathVariable("projectID") String projectID) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(value = "/project/{userID}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<Project>> loadModel(@PathVariable("userID") String userID) {
        // 1. Load all project
        List<Project> projects = projectRepository.findAll();
        // 2. Use userID to check which project can keep phone data etc.
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
