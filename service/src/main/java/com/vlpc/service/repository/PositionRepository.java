package com.vlpc.service.repository;

import com.vlpc.service.model.Position;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PositionRepository extends CrudRepository<Position, Long> {
    @Override
    <S extends Position> S save(S entity);

    @Override
    Optional<Position> findById(Long aLong);

    @Override
    Iterable<Position> findAll();

    @Override
    void delete(Position entity);

    @Override
    void deleteById(Long aLong);
}
