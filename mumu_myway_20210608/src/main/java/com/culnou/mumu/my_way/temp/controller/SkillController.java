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

import com.culnou.mumu.my_way.temp.entity.mongo.Skill;
import com.culnou.mumu.my_way.temp.service.SkillMongoService;


@RestController
public class SkillController {
	
	@Autowired
    private SkillMongoService skillService;

    @GetMapping("/skills")
    public ResponseEntity< List< Skill >> getAllSkill() {
        return ResponseEntity.ok().body(skillService.getAllSkill());
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity < Skill > getSkillById(@PathVariable String id) {
        return ResponseEntity.ok().body(skillService.getSkillById(id));
    }

    @PostMapping("/skills")
    public ResponseEntity < Skill > createSkill(@RequestBody Skill skill) {
        return ResponseEntity.ok().body(this.skillService.createSkill(skill));
    }

    @PutMapping("/skills/{id}")
    public ResponseEntity < Skill > updateSkill(@PathVariable String id, @RequestBody Skill skill) {
        skill.setId(id);
        return ResponseEntity.ok().body(this.skillService.updateSkill(skill));
    }

    @DeleteMapping("/skills/{id}")
    public HttpStatus deleteSkill(@PathVariable String id) {
        this.skillService.deleteSkill(id);
        return HttpStatus.OK;
    }

}
