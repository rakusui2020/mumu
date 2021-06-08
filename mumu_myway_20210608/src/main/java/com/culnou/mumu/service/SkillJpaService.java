package com.culnou.mumu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.entity.jpa.Skill;
import com.culnou.mumu.repository.SkillJpaRepository;

@Service
@Transactional
public class SkillJpaService{
	
	@Autowired
    private SkillJpaRepository skillRepository;
	

	
	public Skill createSkill(Skill skill) {
		// TODO Auto-generated method stub
		
		return skillRepository.save(skill);
	}

	
	public Skill updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		Optional< Skill > skillDb = this.skillRepository.findById(skill.getId());

        if (skillDb.isPresent()) {
            Skill skillUpdate = skillDb.get();
            skillUpdate.setId(skill.getId());
            skillUpdate.setName(skill.getName());
            skillUpdate.setDescription(skill.getDescription());
            skillRepository.save(skillUpdate);
            return skillUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Skill> getAllSkill() {
		// TODO Auto-generated method stub
		return this.skillRepository.findAll();

	}

	
	public Skill getSkillById(String skillId) {
		// TODO Auto-generated method stub
		Optional< Skill > skillDb = this.skillRepository.findById(skillId);
		if (skillDb.isPresent()) {
			return skillDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteSkill(String skillId) {
		// TODO Auto-generated method stub
		Optional < Skill > skillDb = this.skillRepository.findById(skillId);

        if (skillDb.isPresent()) {
            this.skillRepository.delete(skillDb.get());
        } else {
        	System.out.println("error");
        }
		
	}

}
