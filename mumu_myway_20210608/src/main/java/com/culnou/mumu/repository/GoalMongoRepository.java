package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Goal;

public interface GoalMongoRepository extends MongoRepository<Goal, String> {

}
