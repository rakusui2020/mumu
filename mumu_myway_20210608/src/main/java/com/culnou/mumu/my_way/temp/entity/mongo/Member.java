package com.culnou.mumu.my_way.temp.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "members")
@Data
public class Member {
	@Id
	private String id;
	private String name;
	private String description;

}
