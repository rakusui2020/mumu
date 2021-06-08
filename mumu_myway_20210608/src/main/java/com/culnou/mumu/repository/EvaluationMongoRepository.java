package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Evaluation;

public interface EvaluationMongoRepository extends MongoRepository<Evaluation, String> {

}
