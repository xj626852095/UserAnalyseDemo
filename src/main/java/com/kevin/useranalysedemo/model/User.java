package com.kevin.useranalysedemo.model;

public class User {
	
	private String userId;
	private String userName;
	private int provinceId;
	private String provinceName;
	private int age;	
	
	
	
	public User(String userId, String userName, int provinceId, String provinceName, int age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.age = age;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}	
	
}
