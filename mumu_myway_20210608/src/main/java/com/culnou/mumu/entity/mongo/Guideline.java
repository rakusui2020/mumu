package com.culnou.mumu.entity.mongo;



import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "guidelines")
@Data
public class Guideline {
	
	@Id
	private String id;
	private String name;
	private String description;

}
