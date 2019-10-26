package com.social.server.models.address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {

    private String street;
    private String city;
    private String zip;
}