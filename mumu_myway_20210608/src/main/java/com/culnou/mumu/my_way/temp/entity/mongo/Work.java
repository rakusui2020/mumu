package com.culnou.mumu.my_way.temp.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "works")
@Data
public class Work {
	@Id
	private String id;
	private String name;
	private String description;
	private String indicator;
	private String targetValue;
	private String actualValue;
	private String startTime;
	private String endTime;
	private int expendedTime;
	private String formattedExpendedTime;
	private Action action;
}
