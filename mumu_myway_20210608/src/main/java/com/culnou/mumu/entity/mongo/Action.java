package com.culnou.mumu.entity.mongo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "actions")
@Data
public class Action {
	@Id
	private String id;
	private String name;
	private String description;
	private String problem;
	private String solution;
	private String technique;
	private String indicator;
	private String targetValue;
	private String actualValue;
	private String startTime;
	private String endTime;
	private int expendedTime;
	//アラームの時間を記憶するための変数の追加 2021/3/13
	private int alerm;
	private String formattedExpendedTime;
	//job、sleepなどMeのタスクを設定する→不用 2020/11/25
	private String taskName;
	private Project project;
	private String taskId;
	//関連タスクの名前
	private String associatedTaskName;
	private String status;
	private Task task;
	private List<Work> works = new ArrayList<>();
	
}
