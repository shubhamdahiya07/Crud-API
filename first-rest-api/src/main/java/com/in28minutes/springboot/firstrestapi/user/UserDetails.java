package com.in28minutes.springboot.firstrestapi.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String role;

	public UserDetails(Long id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public UserDetails() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

}
