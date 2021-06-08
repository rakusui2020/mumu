package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Evaluation;



public interface EvaluationJpaRepository extends JpaRepository<Evaluation, String> {

}
