package com.culnou.mumu.my_way.temp.entity.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "jobs")
@XmlRootElement
@Data
public class Job {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@ManyToOne
	@JoinColumn(name="users_id")
	@JsonIgnore
	private User user;

}
