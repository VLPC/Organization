package com.vlpc.service;

import com.vlpc.service.model.Employee;
import com.vlpc.service.model.Organization;
import com.vlpc.service.model.Position;
import com.vlpc.service.repository.EmployeeRepository;
import com.vlpc.service.repository.OrganizationRepository;
import com.vlpc.service.repository.PositionRepository;
import com.vlpc.service.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    EmployeeService employeeService;

    @Test
    void givenThereIsNoEmployeesInOrganisation_thenServiceGivesEmptyList() {

        List<Employee> employees = employeeService.findEmployeesForOrganization(0);

        assertThat(employees, is(empty()));
    }

    @Test
    void given2PeopleInOneOrganization_() {

        Organization organization = new Organization("Surgutneftegas", "Gubkina", "Surgut");
        Position position = new Position("manager");

        Employee first = new Employee("Some", "Manager", LocalDate.of(1989, 4, 24), LocalDate.of(2015, 4, 24),
                140000, position, organization);
        Employee second = new Employee("Some", "Manager", LocalDate.of(1989, 4, 24), LocalDate.of(2015, 4, 24),
                140000, position, organization);

        organization = organizationRepository.save(organization);
        positionRepository.save(position);

        employeeRepository.saveAll(Arrays.asList(first, second));

        List<Employee> employees = employeeService.findEmployeesForOrganization(organization.getId());

        assertThat(employees, hasSize(2));
    }
}
