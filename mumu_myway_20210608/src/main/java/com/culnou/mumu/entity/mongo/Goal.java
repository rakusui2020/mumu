package com.culnou.mumu.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "goals")
@Data
public class Goal {
	@Id
	private String id;
	private String name;
	private String description;
	private String kpi;
	private String value;

}
