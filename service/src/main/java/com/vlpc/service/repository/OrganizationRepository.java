package com.vlpc.service.repository;

import com.vlpc.service.model.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {
    @Override
    <S extends Organization> S save(S entity);

    @Override
    Optional<Organization> findById(Long aLong);

    @Override
    Iterable<Organization> findAll();

    @Override
    void delete(Organization entity);

    @Override
    void deleteById(Long aLong);
}
