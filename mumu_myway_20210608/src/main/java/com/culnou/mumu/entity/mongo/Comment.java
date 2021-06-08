package com.culnou.mumu.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "comments")
@Data
public class Comment {
	@Id
	private String id;
	private String name;
	private String description;

}
