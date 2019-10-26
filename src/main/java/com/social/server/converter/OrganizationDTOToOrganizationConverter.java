package com.social.server.converter;

import java.util.UUID;

import com.social.server.models.Organization.Organization;
import com.social.server.models.Organization.OrganizationDTO;

public class OrganizationDTOToOrganizationConverter {


    public static Organization convert(OrganizationDTO dto){
        

        return Organization.builder().id(UUID.randomUUID().toString()).name(dto.getName()).username(dto.getUsername())
                .password(dto.getPassword()).shortDescription(dto.getShortDescription()).logo(dto.getLogo())
                .description(dto.getDescription()).homepage(dto.getHomepage()).email(dto.getEmail())
                .phone(dto.getPhone()).address(dto.getAddress()).pictures(dto.getPictures())
                .pastProjects(dto.getPastProjects()).activeProjects(dto.getActiveProjects()).build();
    }
}