package com.social.server.models.user;

import java.util.ArrayList;
import java.util.List;

import com.social.server.models.project.Project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String birthday;
    private String phone;
    private String profilePicture;
    private List<Project> pastProjects;
    private List<Project> activeProjects;
}