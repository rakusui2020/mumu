package com.culnou.mumu.my_way.temp.entity.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@Table(name = "goals")
@XmlRootElement
@Data
public class Goal {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "kpi")
	private String kpi;
	@Column(name = "value")
	private String value;

}
