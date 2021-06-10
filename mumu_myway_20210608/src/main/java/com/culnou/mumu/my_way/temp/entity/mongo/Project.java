package com.culnou.mumu.my_way.temp.entity.mongo;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Document(collection = "projects")
@Data
public class Project {
	@Id
	private String id;
	private String name;
	private String description;
	private String type;
	private String indicator;
	private String targetValue;
	private String actualValue;
	private String period;
	private int expendedTime;
	private String formattedExpendedTime;
	//親プロジェクトかどうか識別するフラグ 2021/3/16
	private boolean parent;
	private User user;
	private List<Action> actions = new ArrayList<Action>();
	//子プロジェクトを持たせるようにする。2021/3/28
	private List<Project> children = new ArrayList<Project>();
	private String parentId; 
	private String parentName;
	//関連ジョブの情報を持たせる。2021/3/30
	private String jobId;
	private String jobName;
	

}
