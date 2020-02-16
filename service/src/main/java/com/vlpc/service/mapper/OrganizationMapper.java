package com.vlpc.service.mapper;

import com.vlpc.service.dto.OrganizationDto;
import com.vlpc.service.model.Organization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    @Autowired
    ModelMapper modelMapper;

    public Organization toEntity(OrganizationDto organizationDto) {
        return modelMapper.map(organizationDto, Organization.class);
    }

    public OrganizationDto toDto(Organization organization) {
        return modelMapper.map(organization, OrganizationDto.class);
    }
}
