package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.culnou.mumu.entity.mongo.Task;

public interface TaskMongoRepository extends MongoRepository<Task, String> {

}
