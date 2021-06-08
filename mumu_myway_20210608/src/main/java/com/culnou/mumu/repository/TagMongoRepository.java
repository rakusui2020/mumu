package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Tag;



public interface TagMongoRepository extends MongoRepository<Tag, String> {

}
