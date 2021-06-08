package com.culnou.mumu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.culnou.mumu.entity.mongo.Evaluation;
//import com.culnou.mumu.entity.jpa.Evaluation;
import com.culnou.mumu.service.EvaluationMongoService;
//import com.culnou.mumu.service.EvaluationJpaService;


@RestController
public class EvaluationController {
	
	@Autowired
    private EvaluationMongoService evaluationService;

    @GetMapping("/evaluations")
    public ResponseEntity< List< Evaluation >> getAllEvaluation() {
        return ResponseEntity.ok().body(evaluationService.getAllEvaluation());
    }

    @GetMapping("/evaluations/{id}")
    public ResponseEntity < Evaluation > getEvaluationById(@PathVariable String id) {
        return ResponseEntity.ok().body(evaluationService.getEvaluationById(id));
    }

    @PostMapping("/evaluations")
    public ResponseEntity < Evaluation > createEvaluation(@RequestBody Evaluation evaluation) {
        return ResponseEntity.ok().body(this.evaluationService.createEvaluation(evaluation));
    }

    @PutMapping("/evaluations/{id}")
    public ResponseEntity < Evaluation > updateEvaluation(@PathVariable String id, @RequestBody Evaluation evaluation) {
        evaluation.setId(id);
        return ResponseEntity.ok().body(this.evaluationService.updateEvaluation(evaluation));
    }

    @DeleteMapping("/evaluations/{id}")
    public HttpStatus deleteEvaluation(@PathVariable String id) {
        this.evaluationService.deleteEvaluation(id);
        return HttpStatus.OK;
    }

}
