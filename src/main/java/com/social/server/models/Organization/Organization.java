package com.social.server.models.Organization;

import com.social.server.models.address.Address;
import com.social.server.models.project.Project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
@Builder
public class Organization{

    private String id;
    private String name;
    private String username;
    private String password;
    private String shortDescription;
    private String logo;
    private String description;
    private String homepage;
    private String email;
    private String phone;
    private Address address;
    private String[] pictures;
    private Project[] pastProjects;
    private Project[] activeProjects;
}