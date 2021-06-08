package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Work;



public interface WorkJpaRepository extends JpaRepository<Work, String> {

}
