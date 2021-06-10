package com.culnou.mumu.my_way.temp.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culnou.mumu.my_way.temp.entity.mongo.Tag;
import com.culnou.mumu.my_way.temp.repository.TagMongoRepository;



@Service
@Transactional
public class TagMongoService {
	
	@Autowired
    private TagMongoRepository tagRepository;
	//@Autowired
	//private TagJpaService tagJpaService;
	
	
	
	public Tag createTag(Tag tag) {
		// TODO Auto-generated method stub
		/* Jpaにも記録する場合
		com.culnou.mumu.entity.jpa.Tag jpaTag = new com.culnou.mumu.entity.jpa.Tag();
		jpaTag.setId(tag.getId());
		jpaTag.setName(tag.getName());
		jpaTag.setDescription(tag.getDescription());
		tagJpaService.createTag(jpaTag);
		*/
		return tagRepository.save(tag);
		
		
	}

	
	public Tag updateTag(Tag tag) {
		// TODO Auto-generated method stub
		Optional< Tag > tagDb = this.tagRepository.findById(tag.getId());

        if (tagDb.isPresent()) {
            Tag tagUpdate = tagDb.get();
            tagUpdate.setId(tag.getId());
            tagUpdate.setName(tag.getName());
            tagUpdate.setDescription(tag.getDescription());
            tagRepository.save(tagUpdate);
            return tagUpdate;
        } else {
            System.out.println("error");
            return null;
        }
	}

	
	public List<Tag> getAllTag() {
		// TODO Auto-generated method stub
		return this.tagRepository.findAll();
	}

	
	public Tag getTagById(String tagId) {
		// TODO Auto-generated method stub
		Optional< Tag > tagDb = this.tagRepository.findById(tagId);
		if (tagDb.isPresent()) {
			return tagDb.get();
		}else {
			System.out.println("error");
            return null;
		}
	}

	
	public void deleteTag(String tagId) {
		// TODO Auto-generated method stub
		Optional < Tag > tagDb = this.tagRepository.findById(tagId);

        if (tagDb.isPresent()) {
            this.tagRepository.delete(tagDb.get());
        } else {
        	System.out.println("error");
        }

	}

}
