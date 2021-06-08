package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Member;



public interface MemberMongoRepository extends MongoRepository<Member, String> {

}
