package com.culnou.mumu.my_way.temp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.my_way.temp.entity.jpa.Project;



public interface ProjectJpaRepository extends JpaRepository<Project, String> {

}
