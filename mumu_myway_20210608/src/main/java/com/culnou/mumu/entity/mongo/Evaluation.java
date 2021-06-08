package com.culnou.mumu.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "evaluations")
@Data
public class Evaluation {
	@Id
	private String id;
	private String name;
	private String description;

}
