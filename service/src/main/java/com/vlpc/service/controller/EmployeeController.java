package com.vlpc.service.controller;

import com.vlpc.service.dto.EmployeeDto;
import com.vlpc.service.mapper.EmployeeMapper;
import com.vlpc.service.model.Employee;
import com.vlpc.service.service.EmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.vlpc.service.exception.EntityNotFoundException.entityNotFoundException;

@Api("API работы с сотрудниками")
@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Получение данных о всех сотрудниках
     */
    @ApiOperation(value = "Получение данных о всех сотрудниках")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    /**
     * Получение данных о сотруднике
     */
    @ApiOperation(value = "Получение данных о сотруднике по его Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@ApiParam(value = "Employee Id", required = true) @PathVariable long id) {
        Employee employee = employeeService.getEmployeeById(id).orElseThrow(entityNotFoundException("Person not found!"));
        return ResponseEntity.ok(employeeMapper.toDto(employee));
    }

    /**
     * Создание нового сотрудника
     */
    @ApiOperation(value = "Создание нового сотрудника")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Сотрудник успешно создан"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Validated @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.saveEmployee(employeeMapper.toEntity(employeeDto));
        return ResponseEntity.ok(employeeMapper.toDto(employee));
    }

    /**
     * Обновление данных о сотруднике
     */
    @ApiOperation(value = "Обновление данных о сотруднике")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно обновлены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.updateEmployee(id, employeeMapper.toEntity(employeeDto));
        return ResponseEntity.ok(employeeMapper.toDto(employee));
    }

    /**
     * Удаление сотрудника
     */
    @ApiOperation(value = "Удаление сотрудника по его Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Сотрудник успешно удален"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
