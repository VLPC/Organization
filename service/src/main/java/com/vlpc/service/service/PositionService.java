package com.vlpc.service.service;

import com.vlpc.service.dto.PositionDto;
import com.vlpc.service.mapper.PositionMapper;
import com.vlpc.service.model.Position;
import com.vlpc.service.repository.PositionRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {

    private PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository){
        this.positionRepository = positionRepository;
    }

    public Optional<Position> getPositionById(Long id) {
        return positionRepository.findById(id);
    }

    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(Long id, Position position) {
        Position position2update = positionRepository.findById(id).get();

        position2update.setTitle(position.getTitle());

        return positionRepository.save(position2update);
    }

    public void deletePosition(long id) {
        positionRepository.deleteById(id);
    }

    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
