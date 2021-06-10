package com.culnou.mumu.my_way.temp.entity.mongo;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {
	@Id
	private String id;
	private String name;
	private String description;
	private boolean signIn = false;
	private String provider;
	private String fullName = "not provided";
	private String email = "not provided";
	private String authState = "unknown";
	private List<Job> jobs = new ArrayList<Job>();
	private List<Project> projects = new ArrayList<>();
	//Userにプロジェクトのアクションではなくユーザーのルーティンアクションを追加 2020/11/25
    private List<Action> actions = new ArrayList<>();
    //Userにタスクを持たせるようにする。2021/3/26
    private List<Task> tasks = new ArrayList<>();

}
