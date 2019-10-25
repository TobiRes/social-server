package com.social.server.models.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectDTO {
    private String title;
    private String shortDescription;
    private String longDescription;
}
