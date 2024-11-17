package com.xpe.desafio_final.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long addressId;
    private String address;
    private String number;
    private String additionalData;
    private String neighborhood;
    private String zipCode;
    private String country;
    private String state;
    private String city;
}
