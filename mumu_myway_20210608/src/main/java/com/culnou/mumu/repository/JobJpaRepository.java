package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Job;

public interface JobJpaRepository extends JpaRepository<Job, String> {

}
