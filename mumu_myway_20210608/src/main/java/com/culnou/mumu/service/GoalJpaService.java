package com.culnou.mumu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.entity.jpa.Goal;
import com.culnou.mumu.repository.GoalJpaRepository;

@Service
@Transactional
public class GoalJpaService {
	
	@Autowired
    private GoalJpaRepository goalRepository;
	

	
	public Goal createGoal(Goal goal) {
		// TODO Auto-generated method stub
		
		return goalRepository.save(goal);
	}

	
	public Goal updateGoal(Goal goal) {
		// TODO Auto-generated method stub
		Optional< Goal > goalDb = this.goalRepository.findById(goal.getId());

        if (goalDb.isPresent()) {
            Goal goalUpdate = goalDb.get();
            goalUpdate.setId(goal.getId());
            goalUpdate.setName(goal.getName());
            goalUpdate.setDescription(goal.getDescription());
            goalRepository.save(goalUpdate);
            return goalUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Goal> getAllGoal() {
		// TODO Auto-generated method stub
		return this.goalRepository.findAll();

	}

	
	public Goal getGoalById(String goalId) {
		// TODO Auto-generated method stub
		Optional< Goal > goalDb = this.goalRepository.findById(goalId);
		if (goalDb.isPresent()) {
			return goalDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteGoal(String goalId) {
		// TODO Auto-generated method stub
		Optional < Goal > goalDb = this.goalRepository.findById(goalId);

        if (goalDb.isPresent()) {
            this.goalRepository.delete(goalDb.get());
        } else {
        	System.out.println("error");
        }
		
	}

}
