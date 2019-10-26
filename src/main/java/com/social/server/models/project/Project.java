package com.social.server.models.project;

import com.social.server.models.address.Address;
import com.social.server.models.stuffAndThings.StuffAndThings;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Project {
    private String ID;
    private String title;
    private String shortDescription;
    private String longDescription;
    private String createdBy;
    private String startDate;
    private String endDate;
    private Address address;
    private StuffAndThings stuffAndThings;
    private String picture;
}
