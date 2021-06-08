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

import com.culnou.mumu.entity.mongo.Task;
//import com.culnou.mumu.entity.jpa.Task;
import com.culnou.mumu.service.TaskMongoService;
//import com.culnou.mumu.service.TaskJpaService;


@RestController
public class TaskController {
	
	@Autowired
    private TaskMongoService taskService;

    @GetMapping("/tasks")
    public ResponseEntity< List< Task >> getAllTask() {
        return ResponseEntity.ok().body(taskService.getAllTask());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity < Task > getTaskById(@PathVariable String id) {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PostMapping("/tasks")
    public ResponseEntity < Task > createTask(@RequestBody Task task) {
        return ResponseEntity.ok().body(this.taskService.createTask(task));
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity < Task > updateTask(@PathVariable String id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok().body(this.taskService.updateTask(task));
    }

    @DeleteMapping("/tasks/{id}")
    public HttpStatus deleteTask(@PathVariable String id) {
        this.taskService.deleteTask(id);
        return HttpStatus.OK;
    }

}
