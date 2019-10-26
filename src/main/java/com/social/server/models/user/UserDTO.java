package com.social.server.models.user;

import com.social.server.models.project.Project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String birthday;
    private String phone;
    private String profilePicture;
    private Project[] pastProjects;
    private Project[] activeProjects;
}