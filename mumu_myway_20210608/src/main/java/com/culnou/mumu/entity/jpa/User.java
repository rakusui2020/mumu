package com.culnou.mumu.entity.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@Table(name = "users")
@XmlRootElement
@Data
public class User {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "sign_in")
	private boolean signIn = false;
	@Column(name = "provider")
	private String provider;
	@Column(name = "full_name")
	private String fullName = "not provided";
	@Column(name = "email")
	private String email = "not provided";
	@Column(name = "auth_state")
	private String authState = "unknown";
	@OneToMany(cascade={CascadeType.ALL},mappedBy="user")
	private List<Job> jobs = new ArrayList<Job>();

}
