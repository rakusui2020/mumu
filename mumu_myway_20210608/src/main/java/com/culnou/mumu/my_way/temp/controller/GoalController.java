package com.culnou.mumu.my_way.temp.controller;

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

import com.culnou.mumu.my_way.temp.entity.mongo.Goal;
import com.culnou.mumu.my_way.temp.service.GoalMongoService;

@RestController
public class GoalController {
	
	@Autowired
    private GoalMongoService goalService;

    @GetMapping("/goals")
    public ResponseEntity< List< Goal >> getAllGoal() {
        return ResponseEntity.ok().body(goalService.getAllGoal());
    }

    @GetMapping("/goals/{id}")
    public ResponseEntity < Goal > getGoalById(@PathVariable String id) {
        return ResponseEntity.ok().body(goalService.getGoalById(id));
    }

    @PostMapping("/goals")
    public ResponseEntity < Goal > createGoal(@RequestBody Goal goal) {
        return ResponseEntity.ok().body(this.goalService.createGoal(goal));
    }

    @PutMapping("/goals/{id}")
    public ResponseEntity < Goal > updateGoal(@PathVariable String id, @RequestBody Goal goal) {
        goal.setId(id);
        return ResponseEntity.ok().body(this.goalService.updateGoal(goal));
    }

    @DeleteMapping("/goals/{id}")
    public HttpStatus deleteGoal(@PathVariable String id) {
        this.goalService.deleteGoal(id);
        return HttpStatus.OK;
    }

}
