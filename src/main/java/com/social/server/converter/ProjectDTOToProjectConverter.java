package com.social.server.converter;

import com.social.server.models.project.Project;
import com.social.server.models.project.ProjectDTO;

import java.util.ArrayList;
import java.util.UUID;


public class ProjectDTOToProjectConverter {
    public static Project convert(ProjectDTO project) {
        return Project.builder()
                .ID(UUID.randomUUID().toString())
                .title(project.getTitle())
                .shortDescription(project.getShortDescription())
                .longDescription(project.getLongDescription())
                .createdBy(project.getCreatedBy())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .address(project.getAddress())
                .stuffAndThings(project.getStuffAndThings())
                .users(new ArrayList<>())
                .build();
    }
}
