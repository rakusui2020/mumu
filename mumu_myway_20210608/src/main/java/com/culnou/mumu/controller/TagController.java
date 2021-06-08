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

import com.culnou.mumu.entity.mongo.Tag;
//import com.culnou.mumu.entity.jpa.Tag;
import com.culnou.mumu.service.TagMongoService;
//import com.culnou.mumu.service.TagJpaService;


@RestController
public class TagController {
	
	@Autowired
    private TagMongoService tagService;

    @GetMapping("/tags")
    public ResponseEntity< List< Tag >> getAllTag() {
        return ResponseEntity.ok().body(tagService.getAllTag());
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity < Tag > getTagById(@PathVariable String id) {
        return ResponseEntity.ok().body(tagService.getTagById(id));
    }

    @PostMapping("/tags")
    public ResponseEntity < Tag > createTag(@RequestBody Tag tag) {
        return ResponseEntity.ok().body(this.tagService.createTag(tag));
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity < Tag > updateTag(@PathVariable String id, @RequestBody Tag tag) {
        tag.setId(id);
        return ResponseEntity.ok().body(this.tagService.updateTag(tag));
    }

    @DeleteMapping("/tags/{id}")
    public HttpStatus deleteTag(@PathVariable String id) {
        this.tagService.deleteTag(id);
        return HttpStatus.OK;
    }

}
