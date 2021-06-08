package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Project;



public interface ProjectMongoRepository extends MongoRepository<Project, String> {

}
