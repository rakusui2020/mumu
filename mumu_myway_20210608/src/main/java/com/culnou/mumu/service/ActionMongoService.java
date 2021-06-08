package com.culnou.mumu.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.entity.mongo.Action;
import com.culnou.mumu.repository.ActionMongoRepository;



@Service
@Transactional
public class ActionMongoService {
	
	@Autowired
    private ActionMongoRepository actionRepository;
	//@Autowired
	//private ActionJpaService actionJpaService;
	
	
	
	public Action createAction(Action action) {
		// TODO Auto-generated method stub
		/* Jpaにも記録する場合
		com.culnou.mumu.entity.jpa.Action jpaAction = new com.culnou.mumu.entity.jpa.Action();
		jpaAction.setId(action.getId());
		jpaAction.setName(action.getName());
		jpaAction.setDescription(action.getDescription());
		actionJpaService.createAction(jpaAction);
		*/
		return actionRepository.save(action);
		
		
	}

	
	public Action updateAction(Action action) {
		// TODO Auto-generated method stub
		Optional< Action > actionDb = this.actionRepository.findById(action.getId());

        if (actionDb.isPresent()) {
            Action actionUpdate = actionDb.get();
            actionUpdate.setId(action.getId());
            actionUpdate.setName(action.getName());
            actionUpdate.setDescription(action.getDescription());
            actionRepository.save(actionUpdate);
            return actionUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Action> getAllAction() {
		// TODO Auto-generated method stub
		return this.actionRepository.findAll();
	}

	
	public Action getActionById(String actionId) {
		// TODO Auto-generated method stub
		Optional< Action > actionDb = this.actionRepository.findById(actionId);
		if (actionDb.isPresent()) {
			return actionDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteAction(String actionId) {
		// TODO Auto-generated method stub
		Optional < Action > actionDb = this.actionRepository.findById(actionId);

        if (actionDb.isPresent()) {
            this.actionRepository.delete(actionDb.get());
        } else {
        	System.out.println("error");
        }

	}

}
