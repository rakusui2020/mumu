package com.culnou.mumu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.entity.jpa.Evaluation;
import com.culnou.mumu.repository.EvaluationJpaRepository;

@Service
@Transactional
public class EvaluationJpaService{
	
	@Autowired
    private EvaluationJpaRepository evaluationRepository;
	

	
	public Evaluation createEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		
		return evaluationRepository.save(evaluation);
	}

	
	public Evaluation updateEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		Optional< Evaluation > evaluationDb = this.evaluationRepository.findById(evaluation.getId());

        if (evaluationDb.isPresent()) {
            Evaluation evaluationUpdate = evaluationDb.get();
            evaluationUpdate.setId(evaluation.getId());
            evaluationUpdate.setName(evaluation.getName());
            evaluationUpdate.setDescription(evaluation.getDescription());
            evaluationRepository.save(evaluationUpdate);
            return evaluationUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Evaluation> getAllEvaluation() {
		// TODO Auto-generated method stub
		return this.evaluationRepository.findAll();

	}

	
	public Evaluation getEvaluationById(String evaluationId) {
		// TODO Auto-generated method stub
		Optional< Evaluation > evaluationDb = this.evaluationRepository.findById(evaluationId);
		if (evaluationDb.isPresent()) {
			return evaluationDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteEvaluation(String evaluationId) {
		// TODO Auto-generated method stub
		Optional < Evaluation > evaluationDb = this.evaluationRepository.findById(evaluationId);

        if (evaluationDb.isPresent()) {
            this.evaluationRepository.delete(evaluationDb.get());
        } else {
        	System.out.println("error");
        }
		
	}

}
