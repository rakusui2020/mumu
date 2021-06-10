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

import com.culnou.mumu.my_way.temp.entity.mongo.Action;
import com.culnou.mumu.my_way.temp.service.ActionMongoService;


@RestController
public class ActionController {
	
	@Autowired
    private ActionMongoService actionService;

    @GetMapping("/actions")
    public ResponseEntity< List< Action >> getAllAction() {
        return ResponseEntity.ok().body(actionService.getAllAction());
    }

    @GetMapping("/actions/{id}")
    public ResponseEntity < Action > getActionById(@PathVariable String id) {
        return ResponseEntity.ok().body(actionService.getActionById(id));
    }

    @PostMapping("/actions")
    public ResponseEntity < Action > createAction(@RequestBody Action action) {
        return ResponseEntity.ok().body(this.actionService.createAction(action));
    }

    @PutMapping("/actions/{id}")
    public ResponseEntity < Action > updateAction(@PathVariable String id, @RequestBody Action action) {
        action.setId(id);
        return ResponseEntity.ok().body(this.actionService.updateAction(action));
    }

    @DeleteMapping("/actions/{id}")
    public HttpStatus deleteAction(@PathVariable String id) {
        this.actionService.deleteAction(id);
        return HttpStatus.OK;
    }

}
