package com.culnou.mumu.my_way.temp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.my_way.temp.entity.mongo.Evaluation;

public interface EvaluationMongoRepository extends MongoRepository<Evaluation, String> {

}
