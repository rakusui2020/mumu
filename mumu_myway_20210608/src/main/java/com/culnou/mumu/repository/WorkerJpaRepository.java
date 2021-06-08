package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Worker;



public interface WorkerJpaRepository extends JpaRepository<Worker, String> {

}
