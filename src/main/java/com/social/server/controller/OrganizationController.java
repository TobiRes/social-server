package com.social.server.controller;

import java.util.List;

import com.social.server.converter.OrganizationDTOToOrganizationConverter;
import com.social.server.converter.ProjectDTOToProjectConverter;
import com.social.server.converter.UserDTOToUserConcerter;
import com.social.server.models.Organization.Organization;
import com.social.server.models.Organization.OrganizationDTO;
import com.social.server.models.project.Project;
import com.social.server.models.project.ProjectDTO;
import com.social.server.models.user.User;
import com.social.server.models.user.UserDTO;
import com.social.server.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
public class OrganizationController{

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationController(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }


    @RequestMapping(value="/org/register", 
    produces = {"application/json"}, 
    method = RequestMethod.POST) 
    public ResponseEntity<Organization> createOrg(@RequestBody OrganizationDTO body) {

        Organization newOrg = OrganizationDTOToOrganizationConverter.convert(body);
        this.organizationRepository.save(newOrg);
        return new ResponseEntity<>(newOrg, HttpStatus.OK);
    }

    @RequestMapping(value="/org/login",
    produces = {"application/json"},
    method = RequestMethod.POST)
    public ResponseEntity<Organization> getSingleOrgById(@RequestBody OrganizationDTO loginUser){
        
        
        List<Organization> orgList = organizationRepository.findAll();

        Organization foundOrg = null;
        for(Organization temp : orgList){
            if(temp.getUsername().equals(loginUser.getUsername())){
                foundOrg = temp;
            }
        }

        return new ResponseEntity<>(foundOrg, HttpStatus.BAD_REQUEST);
    }
}