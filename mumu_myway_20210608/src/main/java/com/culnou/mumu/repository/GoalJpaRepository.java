package com.culnou.mumu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Goal;

public interface GoalJpaRepository extends JpaRepository<Goal, String> {

}
