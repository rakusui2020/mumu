package com.culnou.mumu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.culnou.mumu.entity.jpa.Skill;



public interface SkillJpaRepository extends JpaRepository<Skill, String> {

}
