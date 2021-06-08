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

import com.culnou.mumu.entity.mongo.Worker;
//import com.culnou.mumu.entity.jpa.Worker;
import com.culnou.mumu.service.WorkerMongoService;
//import com.culnou.mumu.service.WorkerJpaService;


@RestController
public class WorkerController {
	
	@Autowired
    private WorkerMongoService workerService;

    @GetMapping("/workers")
    public ResponseEntity< List< Worker >> getAllWorker() {
        return ResponseEntity.ok().body(workerService.getAllWorker());
    }

    @GetMapping("/workers/{id}")
    public ResponseEntity < Worker > getWorkerById(@PathVariable String id) {
        return ResponseEntity.ok().body(workerService.getWorkerById(id));
    }

    @PostMapping("/workers")
    public ResponseEntity < Worker > createWorker(@RequestBody Worker worker) {
        return ResponseEntity.ok().body(this.workerService.createWorker(worker));
    }

    @PutMapping("/workers/{id}")
    public ResponseEntity < Worker > updateWorker(@PathVariable String id, @RequestBody Worker worker) {
        worker.setId(id);
        return ResponseEntity.ok().body(this.workerService.updateWorker(worker));
    }

    @DeleteMapping("/workers/{id}")
    public HttpStatus deleteWorker(@PathVariable String id) {
        this.workerService.deleteWorker(id);
        return HttpStatus.OK;
    }

}
