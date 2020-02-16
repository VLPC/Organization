package com.vlpc.service.mapper;

import com.vlpc.service.dto.PositionDto;
import com.vlpc.service.model.Position;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {
    @Autowired
    ModelMapper modelMapper;

    public Position toEntity(PositionDto positionDto) {
        return modelMapper.map(positionDto, Position.class);
    }

    public PositionDto toDto(Position position) {
        return modelMapper.map(position, PositionDto.class);
    }
}
