package com.vlpc.service;

import com.vlpc.service.dto.EmployeeDto;
import com.vlpc.service.mapper.EmployeeMapper;
import com.vlpc.service.model.Employee;
import com.vlpc.service.model.Organization;
import com.vlpc.service.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeDtoMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void whenConvertEntityToDto_thenCorrect() {

        Organization organization = new Organization("Surgutneftegas", "Gubkina", "Surgut");
        Position position = new Position("manager");

        Employee employee = new Employee("Some", "Manager", LocalDate.of(1989, 4, 24), LocalDate.of(2015, 4, 24),
                140000, position, organization);

        EmployeeDto employeeDto = employeeMapper.toDto(employee);

        assertEquals(employee.getFirstName(), employeeDto.getFirstName());
        assertEquals(employee.getLastName(), employeeDto.getLastName());
        assertEquals(employee.getBirthDate(), employeeDto.getBirthDate());
        assertEquals(employee.getStartDate(), employeeDto.getStartDate());
        assertEquals(employee.getSalary(), employeeDto.getSalary());
        assertEquals(employee.getPosition(), employeeDto.getPosition());
        assertEquals(employee.getOrganization(), employeeDto.getOrganization());
    }

    @Test
    void whenConvertDtoToEntity_thenCorrect() {

        Organization organization = new Organization("Surgutneftegas", "Gubkina", "Surgut");
        Position position = new Position("manager");

        EmployeeDto employeeDto = new EmployeeDto("Some", "Manager", LocalDate.of(1989, 4, 24), LocalDate.of(2015, 4, 24),
                140000, position, organization);

        Employee employee = employeeMapper.toEntity(employeeDto);

        assertEquals(employeeDto.getFirstName(), employee.getFirstName());
        assertEquals(employeeDto.getLastName(), employee.getLastName());
        assertEquals(employeeDto.getBirthDate(), employee.getBirthDate());
        assertEquals(employeeDto.getStartDate(), employee.getStartDate());
        assertEquals(employeeDto.getSalary(), employee.getSalary());
        assertEquals(employeeDto.getPosition(), employee.getPosition());
        assertEquals(employeeDto.getOrganization(), employee.getOrganization());
    }
}
