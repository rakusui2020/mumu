package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.mongo.Member;
import com.culnou.mumu.my_way.temp.repository.MemberMongoRepository;



@Service
@Transactional
public class MemberMongoService {
	
	@Autowired
    private MemberMongoRepository memberRepository;
	//@Autowired
	//private MemberJpaService memberJpaService;
	
	
	
	public Member createMember(Member member) {
		// TODO Auto-generated method stub
		/* Jpaにも記録する場合
		com.culnou.mumu.entity.jpa.Member jpaMember = new com.culnou.mumu.entity.jpa.Member();
		jpaMember.setId(member.getId());
		jpaMember.setName(member.getName());
		jpaMember.setDescription(member.getDescription());
		memberJpaService.createMember(jpaMember);
		*/
		return memberRepository.save(member);
		
		
	}

	
	public Member updateMember(Member member) {
		// TODO Auto-generated method stub
		Optional< Member > memberDb = this.memberRepository.findById(member.getId());

        if (memberDb.isPresent()) {
            Member memberUpdate = memberDb.get();
            memberUpdate.setId(member.getId());
            memberUpdate.setName(member.getName());
            memberUpdate.setDescription(member.getDescription());
            memberRepository.save(memberUpdate);
            return memberUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Member> getAllMember() {
		// TODO Auto-generated method stub
		return this.memberRepository.findAll();
	}

	
	public Member getMemberById(String memberId) {
		// TODO Auto-generated method stub
		Optional< Member > memberDb = this.memberRepository.findById(memberId);
		if (memberDb.isPresent()) {
			return memberDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteMember(String memberId) {
		// TODO Auto-generated method stub
		Optional < Member > memberDb = this.memberRepository.findById(memberId);

        if (memberDb.isPresent()) {
            this.memberRepository.delete(memberDb.get());
        } else {
        	System.out.println("error");
        }

	}

}
