package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Project;



public interface ProjectJpaRepository extends JpaRepository<Project, String> {

}
