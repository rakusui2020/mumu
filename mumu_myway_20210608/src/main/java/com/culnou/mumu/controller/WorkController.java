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

import com.culnou.mumu.entity.mongo.Work;
//import com.culnou.mumu.entity.jpa.Work;
import com.culnou.mumu.service.WorkMongoService;
//import com.culnou.mumu.service.WorkJpaService;


@RestController
public class WorkController {
	
	@Autowired
    private WorkMongoService workService;

    @GetMapping("/works")
    public ResponseEntity< List< Work >> getAllWork() {
        return ResponseEntity.ok().body(workService.getAllWork());
    }

    @GetMapping("/works/{id}")
    public ResponseEntity < Work > getWorkById(@PathVariable String id) {
        return ResponseEntity.ok().body(workService.getWorkById(id));
    }

    @PostMapping("/works")
    public ResponseEntity < Work > createWork(@RequestBody Work work) {
        return ResponseEntity.ok().body(this.workService.createWork(work));
    }

    @PutMapping("/works/{id}")
    public ResponseEntity < Work > updateWork(@PathVariable String id, @RequestBody Work work) {
        work.setId(id);
        return ResponseEntity.ok().body(this.workService.updateWork(work));
    }

    @DeleteMapping("/works/{id}")
    public HttpStatus deleteWork(@PathVariable String id) {
        this.workService.deleteWork(id);
        return HttpStatus.OK;
    }

}
