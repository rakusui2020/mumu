package com.culnou.mumu.my_way.temp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.my_way.temp.entity.jpa.Goal;

public interface GoalJpaRepository extends JpaRepository<Goal, String> {

}
