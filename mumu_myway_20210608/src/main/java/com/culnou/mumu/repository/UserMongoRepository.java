package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.User;

public interface UserMongoRepository extends MongoRepository<User, String> {

}
