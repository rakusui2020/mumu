package com.culnou.mumu.entity.mongo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "tasks")
@Data
public class Task {
	@Id
	private String id;
	private String name;
	private String description;
	private String type;
	private String category;
	private Job job;
	private User user;
	private List<Action> actions = new ArrayList<Action>();
	private List<Awareness> awarenesses = new ArrayList<Awareness>();
	private List<Guideline> guidelines = new ArrayList<Guideline>();

}
