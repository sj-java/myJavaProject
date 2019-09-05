package com.haoyun.personnelProject.bean;

public class Student {
	private String id;
	private String name;
	private String code;
	private String isClass;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIsClass() {
		return isClass;
	}
	public void setIsClass(String isClass) {
		this.isClass = isClass;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", code=" + code + ", isClass=" + isClass + "]";
	}
	
	
}
