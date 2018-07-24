package com.sample.cloud.view.thymeleaf.user.entity;

public class User {
	
	private String id;

	private String name;

	private Integer age;

	private Integer height;

	private Integer weight;

	public Integer getAge() {
		return age;
	}

	public Integer getHeight() {
		return height;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
