package com.vlpc.service.dto;

import com.vlpc.service.model.Organization;
import com.vlpc.service.model.Position;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class EmployeeDto {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private LocalDate birthDate;

    @NonNull
    private LocalDate startDate;

    @NonNull
    @Positive
    private double salary;

    @NonNull
    private Position position;

    @NonNull
    private Organization organization;

    public EmployeeDto(String firstName, String lastName, LocalDate birthDate, LocalDate startDate,
                       double salary, Position position, Organization organization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.salary = salary;
        this.position = position;
        this.organization = organization;
    }

    public EmployeeDto(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
