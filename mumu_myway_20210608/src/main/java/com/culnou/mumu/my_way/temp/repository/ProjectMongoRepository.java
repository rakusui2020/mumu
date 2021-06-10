package com.culnou.mumu.my_way.temp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.my_way.temp.entity.mongo.Project;



public interface ProjectMongoRepository extends MongoRepository<Project, String> {

}
