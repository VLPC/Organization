package com.vlpc.service.repository;

import com.vlpc.service.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    <S extends Employee> S save(S entity);

    @Override
    Optional<Employee> findById(Long aLong);

    @Override
    Iterable<Employee> findAll();

    @Override
    void delete(Employee entity);

    @Override
    void deleteById(Long aLong);

    List<Employee> findEmployeesByOrganization_Id(@Param("id") long id);

    List<Employee> findEmployeesByPosition_Id(@Param("id") long id);

    @Query(value = "SELECT AVG(salary) FROM employee GROUP BY organization_id HAVING organization_id = :id", nativeQuery = true)
    double findAverageSalaryForOrganization_Id(@Param("id") long id);

    @Query(value = "SELECT AVG(salary) FROM employee GROUP BY position_id HAVING position_id = :id", nativeQuery = true)
    double findAverageSalaryForPosition_Id(@Param("id") long id);
}
