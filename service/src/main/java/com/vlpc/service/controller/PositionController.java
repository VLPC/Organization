package com.vlpc.service.controller;

import com.vlpc.service.dto.PositionDto;
import com.vlpc.service.mapper.PositionMapper;
import com.vlpc.service.model.Employee;
import com.vlpc.service.model.Position;
import com.vlpc.service.service.EmployeeService;
import com.vlpc.service.service.PositionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.vlpc.service.exception.EntityNotFoundException.entityNotFoundException;

@Api("API работы с должностями")
@RestController
@RequestMapping("positions")
public class PositionController {

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Получение данных о всех должностях
     */
    @ApiOperation(value = "Получение данных о всех должностях")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping
    public ResponseEntity<Iterable<Position>> getAllPositions() {
        return ResponseEntity.ok(positionService.findAll());
    }

    /**
     * Получение данных о должности
     */
    @ApiOperation(value = "Получение данных о дожности по Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping("{id}")
    public ResponseEntity<PositionDto> getPosition(@ApiParam(value = "Position Id", required = true) @PathVariable long id) {
        Position position = positionService.getPositionById(id).orElseThrow(entityNotFoundException("Position not found!"));
        return ResponseEntity.ok(positionMapper.toDto(position));
    }

    /**
     * Получение всех сотрудников для должности
     */
    @ApiOperation(value = "Получение всех сотрудников для должности")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping("{id}/employees")
    public ResponseEntity<List<Employee>> getAllEmployeesForPosition(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.findEmployeesForPosition(id));
    }

    /**
     * Получение средней зарплаты для должности
     */
    @ApiOperation(value = "Получение средней зарплаты для должности")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно найдены"),
            @ApiResponse(code = 400, message = "Параметры для поиска не получены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @GetMapping("{id}/salary")
    public ResponseEntity<Double> getAverageSalaryForPosition(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.findAverageSalaryForPosition_Id(id));
    }

    /**
     * Создание новой должности
     */
    @ApiOperation(value = "Создание новой должности")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Должность успешно создана"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @PostMapping
    public ResponseEntity<PositionDto> createPosition(@Validated @RequestBody PositionDto positionDto) {
        Position position = positionService.savePosition(positionMapper.toEntity(positionDto));
        return ResponseEntity.ok(positionMapper.toDto(position));
    }

    /**
     * Обновление данных о должности
     */
    @ApiOperation(value = "Обновление данных о должности")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные успешно обновлены"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @PutMapping("update/{id}")
    public ResponseEntity<PositionDto> updatePosition(@PathVariable Long id, @RequestBody PositionDto positionDto) {
        Position position = positionService.updatePosition(id, positionMapper.toEntity(positionDto));
        return ResponseEntity.ok(positionMapper.toDto(position));
    }

    /**
     * Удаление должности
     */
    @ApiOperation(value = "Удаление должности по ее Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Должность успешно удалена"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка")
    })
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable long id) {
        positionService.deletePosition(id);
        return ResponseEntity.ok().build();
    }
}
