package com.culnou.mumu.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Job;
public interface JobMongoRepository extends MongoRepository<Job, String> {
	
	

}
