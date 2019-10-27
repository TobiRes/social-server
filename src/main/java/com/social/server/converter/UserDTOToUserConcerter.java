package com.social.server.converter;

import java.util.ArrayList;
import java.util.UUID;

import com.social.server.models.user.User;
import com.social.server.models.user.UserDTO;

public class UserDTOToUserConcerter {
    public static User converter(UserDTO dto){
        
        return User.builder().
        id(UUID.randomUUID().toString())
        .username(dto.getUsername())
        .password(dto.getPassword())
        .email(dto.getEmail())
        .birthday(dto.getEmail())
        .phone(dto.getPhone())
        .profilePicture(dto.getProfilePicture())
        .activeProjects(new ArrayList<>())
        .build();
    }


}