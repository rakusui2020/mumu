package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Work;



public interface WorkMongoRepository extends MongoRepository<Work, String> {

}
