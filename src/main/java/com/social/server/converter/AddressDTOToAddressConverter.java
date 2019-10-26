package com.social.server.converter;

import com.social.server.models.address.Address;
import com.social.server.models.address.AddressDTO;

public class AddressDTOToAddressConverter {


    public static Address convert(AddressDTO address){
        return Address.builder().
        city(address.getCity()).
        zip(address.getZip()).
        street(address.getStreet()).
        build();
    }
}