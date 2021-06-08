package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Worker;



public interface WorkerMongoRepository extends MongoRepository<Worker, String> {

}
