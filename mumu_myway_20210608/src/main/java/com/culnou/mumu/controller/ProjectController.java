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

import com.culnou.mumu.entity.mongo.Project;
//import com.culnou.mumu.entity.jpa.Project;
import com.culnou.mumu.service.ProjectMongoService;
//import com.culnou.mumu.service.ProjectJpaService;


@RestController
public class ProjectController {
	
	@Autowired
    private ProjectMongoService projectService;

    @GetMapping("/projects")
    public ResponseEntity< List< Project >> getAllProject() {
        return ResponseEntity.ok().body(projectService.getAllProject());
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity < Project > getProjectById(@PathVariable String id) {
        return ResponseEntity.ok().body(projectService.getProjectById(id));
    }

    @PostMapping("/projects")
    public ResponseEntity < Project > createProject(@RequestBody Project project) {
        return ResponseEntity.ok().body(this.projectService.createProject(project));
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity < Project > updateProject(@PathVariable String id, @RequestBody Project project) {
        project.setId(id);
        return ResponseEntity.ok().body(this.projectService.updateProject(project));
    }

    @DeleteMapping("/projects/{id}")
    public HttpStatus deleteProject(@PathVariable String id) {
        this.projectService.deleteProject(id);
        return HttpStatus.OK;
    }

}
