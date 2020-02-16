package com.vlpc.service.controller;

import com.vlpc.service.dto.OrganizationDto;
import com.vlpc.service.mapper.OrganizationMapper;
import com.vlpc.service.model.Employee;
import com.vlpc.service.model.Organization;
import com.vlpc.service.service.EmployeeService;
import com.vlpc.service.service.OrganizationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.vlpc.service.exception.EntityNotFoundException.entityNotFoundException;

@Api("API работы с организациями")
@RestController
@RequestMapping("organizations")
public class OrganizationController {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Получение данных о всех организациях")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping
    public ResponseEntity<Iterable<Organization>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.findAll());
    }

    /**
     * Получение данных об организации
     */
    @ApiOperation(value = "Получение данных об организации по Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping("{id}")
    public ResponseEntity<OrganizationDto> getOrganization(@ApiParam(value = "Employee Id", required = true) @PathVariable long id) {
        Organization organization = organizationService.getOrganizationById(id).orElseThrow(entityNotFoundException("Organization not found!"));
        return ResponseEntity.ok(organizationMapper.toDto(organization));
    }

    /**
     * Получение всех сотрудников для организации
     */
    @ApiOperation(value = "Получение всех сотрудников для организации")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping("{id}/employees")
    public ResponseEntity<List<Employee>> getAllEmployeesForOrganization(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.findEmployeesForOrganization(id));
    }

    /**
     * Получение средней зарплаты для организации
     */
    @ApiOperation(value = "Получение средней зарплаты для организации")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping("{id}/salary")
    public ResponseEntity<Double> getAverageSalaryForOrganization(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.findAverageSalaryForOrganization_Id(id));
    }

    /**
     * Создание новой организации
     */
    @ApiOperation(value = "Создание новой организации")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Организации успешно создана"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @PostMapping
    public ResponseEntity<OrganizationDto> createOrganization(@Validated @RequestBody OrganizationDto organizationDto) {
        Organization organization = organizationService.saveOrganization(organizationMapper.toEntity(organizationDto));
        return ResponseEntity.ok(organizationMapper.toDto(organization));
    }

    /**
     * Обновление данных об организации
     */
    @ApiOperation(value = "Обновление данных об организации")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно обновлены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @PutMapping("update/{id}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable Long id, @RequestBody OrganizationDto organizationDto) {
        Organization organization = organizationService.updateOrganization(id, organizationMapper.toEntity(organizationDto));
        return ResponseEntity.ok(organizationMapper.toDto(organization));
    }

    /**
     * Удаление организации
     */
    @ApiOperation(value = "Удаление организации по ее Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Организации успешно удалена"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable long id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.ok().build();
    }
}
