package com.vlpc.service;

import com.vlpc.service.dto.PositionDto;
import com.vlpc.service.mapper.PositionMapper;
import com.vlpc.service.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PositionDtoMapperTest {

    @Autowired
    PositionMapper positionMapper;

    @Test
    void whenConvertEntityToDto_thenCorrect() {

        Position position = new Position("Junior developer");

        PositionDto positionDto = positionMapper.toDto(position);

        assertEquals(position.getTitle(), positionDto.getTitle());
    }

    @Test
    void whenConvertDtoToEntity_thenCorrect() {

        PositionDto positionDto = new PositionDto("Junior developer");

        Position position = positionMapper.toEntity(positionDto);

        assertEquals(positionDto.getTitle(), position.getTitle());
    }

}
