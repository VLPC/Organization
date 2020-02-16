package com.vlpc.service.model;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;


@Entity(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "fname")
    private String firstName;

    @NonNull
    @Column(name = "lname")
    private String lastName;

    @NonNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NonNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @NonNull
    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public Employee(String firstName, String lastName, LocalDate birthDate, LocalDate startDate,
                    double salary, Position position, Organization organization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.salary = salary;
        this.position = position;
        this.organization = organization;
    }

    public Employee(){}

    public long getId() {
        return id;
    }

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
