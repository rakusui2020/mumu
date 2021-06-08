package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Skill;



public interface SkillMongoRepository extends MongoRepository<Skill, String> {

}
