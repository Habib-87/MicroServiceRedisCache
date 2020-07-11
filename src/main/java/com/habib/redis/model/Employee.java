package com.habib.redis.model;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private String id;
	private String name;
	private Long salary;
	
	public Employee(String id, String name, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	

}
