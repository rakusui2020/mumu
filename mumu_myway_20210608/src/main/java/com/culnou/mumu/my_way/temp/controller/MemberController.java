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

import com.culnou.mumu.my_way.temp.entity.mongo.Member;
import com.culnou.mumu.my_way.temp.service.MemberMongoService;


@RestController
public class MemberController {
	
	@Autowired
    private MemberMongoService memberService;

    @GetMapping("/members")
    public ResponseEntity< List< Member >> getAllMember() {
        return ResponseEntity.ok().body(memberService.getAllMember());
    }

    @GetMapping("/members/{id}")
    public ResponseEntity < Member > getMemberById(@PathVariable String id) {
        return ResponseEntity.ok().body(memberService.getMemberById(id));
    }

    @PostMapping("/members")
    public ResponseEntity < Member > createMember(@RequestBody Member member) {
        return ResponseEntity.ok().body(this.memberService.createMember(member));
    }

    @PutMapping("/members/{id}")
    public ResponseEntity < Member > updateMember(@PathVariable String id, @RequestBody Member member) {
        member.setId(id);
        return ResponseEntity.ok().body(this.memberService.updateMember(member));
    }

    @DeleteMapping("/members/{id}")
    public HttpStatus deleteMember(@PathVariable String id) {
        this.memberService.deleteMember(id);
        return HttpStatus.OK;
    }

}
