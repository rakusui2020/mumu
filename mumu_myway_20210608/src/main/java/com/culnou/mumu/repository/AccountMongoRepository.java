package com.culnou.mumu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.culnou.mumu.entity.mongo.Account;


public interface AccountMongoRepository extends MongoRepository<Account, String> {

}
