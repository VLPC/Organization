package com.vlpc.service.service;

import com.vlpc.service.dto.EmployeeDto;
import com.vlpc.service.mapper.EmployeeMapper;
import com.vlpc.service.model.Employee;
import com.vlpc.service.model.Organization;
import com.vlpc.service.model.Position;
import com.vlpc.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(long id, Employee employee) {

        Employee employee2update = employeeRepository.findById(id).get();

        employee2update.setFirstName(employee.getFirstName());
        employee2update.setLastName(employee.getLastName());
        employee2update.setBirthDate(employee.getBirthDate());
        employee2update.setStartDate(employee.getStartDate());
        employee2update.setSalary(employee.getSalary());
        employee2update.setPosition(employee.getPosition());
        employee2update.setOrganization(employee.getOrganization());

        return employeeRepository.save(employee2update);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findEmployeesForOrganization(long id){
        return employeeRepository.findEmployeesByOrganization_Id(id);
    }

    public List<Employee> findEmployeesForPosition(long id){
        return employeeRepository.findEmployeesByPosition_Id(id);
    }

    public double findAverageSalaryForOrganization_Id(long id){
        return employeeRepository.findAverageSalaryForOrganization_Id(id);
    }

    public double findAverageSalaryForPosition_Id(long id){
        return employeeRepository.findAverageSalaryForPosition_Id(id);
    }
}
