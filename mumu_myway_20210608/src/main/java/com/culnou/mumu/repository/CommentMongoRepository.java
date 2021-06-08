package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Comment;

public interface CommentMongoRepository extends MongoRepository<Comment, String> {

}
