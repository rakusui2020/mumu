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

import com.culnou.mumu.entity.mongo.User;
import com.culnou.mumu.service.UserMongoService;

@RestController
public class UserController {
	@Autowired
    private UserMongoService userService;

    @GetMapping("/users")
    public ResponseEntity< List< User >> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity < User > getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity < User > createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity < User > updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }

    @DeleteMapping("/users/{id}")
    public HttpStatus deleteUser(@PathVariable String id) {
        this.userService.deleteUser(id);
        return HttpStatus.OK;
    }

}
