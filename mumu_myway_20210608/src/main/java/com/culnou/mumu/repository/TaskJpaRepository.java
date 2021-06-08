package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Task;



public interface TaskJpaRepository extends JpaRepository<Task, String> {

}
