package com.culnou.mumu.my_way.temp.entity.mongo;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "jobs")
@Data
public class Job {
	@Id
	private String id;
	private String name;
	private String description;
	private String type;
	private List<Task> tasks = new ArrayList<>();
	private User user;

}
