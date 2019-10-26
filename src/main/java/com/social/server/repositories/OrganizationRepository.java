package com.social.server.repositories;

import com.social.server.models.Organization.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrganizationRepository extends MongoRepository<Organization, String> {
}