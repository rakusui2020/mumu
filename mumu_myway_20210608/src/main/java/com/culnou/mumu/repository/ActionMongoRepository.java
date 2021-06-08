package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Action;



public interface ActionMongoRepository extends MongoRepository<Action, String> {

}
