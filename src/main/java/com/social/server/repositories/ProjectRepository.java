package com.social.server.repositories;

import com.social.server.models.project.Project;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProjectRepository extends MongoRepository<Project, String> { }


