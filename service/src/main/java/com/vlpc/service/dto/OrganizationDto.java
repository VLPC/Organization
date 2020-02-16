package com.vlpc.service.dto;

import org.springframework.lang.NonNull;

public class OrganizationDto {

    @NonNull
    private String name;

    @NonNull
    private String address;

    @NonNull
    private String city;

    public OrganizationDto(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public OrganizationDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
