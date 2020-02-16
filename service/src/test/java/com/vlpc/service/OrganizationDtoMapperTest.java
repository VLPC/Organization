package com.vlpc.service;

import com.vlpc.service.dto.OrganizationDto;
import com.vlpc.service.mapper.OrganizationMapper;
import com.vlpc.service.model.Organization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrganizationDtoMapperTest {

    @Autowired
    OrganizationMapper organizationMapper;

    @Test
    void whenConvertEntityToDto_thenCorrect() {

        Organization organization = new Organization("Surgutneftegas", "Gubkina", "Surgut");

        OrganizationDto organizationDto = organizationMapper.toDto(organization);

        assertEquals(organization.getName(), organizationDto.getName());
        assertEquals(organization.getAddress(), organizationDto.getAddress());
        assertEquals(organization.getCity(), organizationDto.getCity());
    }

    @Test
    void whenConvertDtoToEntity_thenCorrect() {

        OrganizationDto organizationDto = new OrganizationDto("Surgutneftegas", "Gubkina", "Surgut");

        Organization organization = organizationMapper.toEntity(organizationDto);

        assertEquals(organizationDto.getName(), organization.getName());
        assertEquals(organizationDto.getAddress(), organization.getAddress());
        assertEquals(organizationDto.getCity(), organization.getCity());
    }
}
