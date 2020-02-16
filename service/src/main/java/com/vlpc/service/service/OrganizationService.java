package com.vlpc.service.service;

import com.vlpc.service.model.Organization;
import com.vlpc.service.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    public Optional<Organization> getOrganizationById(Long id) {
        return organizationRepository.findById(id);
    }

    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(Long id, Organization organization) {

        Organization organization2update = organizationRepository.findById(id).get();

        organization2update.setName(organization.getName());
        organization2update.setAddress(organization.getAddress());
        organization2update.setCity(organization.getCity());

        return organizationRepository.save(organization2update);
    }

    public void deleteOrganization(long id) {
        organizationRepository.deleteById(id);
    }

    public Iterable<Organization> findAll() {
        return organizationRepository.findAll();
    }
}
