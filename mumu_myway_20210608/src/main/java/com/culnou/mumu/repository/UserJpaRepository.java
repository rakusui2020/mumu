package com.culnou.mumu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.User;

public interface UserJpaRepository extends JpaRepository<User, String> {

}
