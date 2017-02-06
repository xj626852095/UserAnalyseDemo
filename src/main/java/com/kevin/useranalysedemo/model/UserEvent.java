package com.kevin.useranalysedemo.model;

import java.util.Date;

public class UserEvent {
	
	private String userId;
	private String userName;
	private int provinceId;
	private String provinceName;
	private int age;
	
	private int eventId;
	private String eventName;
	private Date statDate;
	private String productName;
	
	
	
	public UserEvent(String userId, String userName, int provinceId, String provinceName, int age, int eventId,
			String eventName, Date statDate, String productName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.age = age;
		this.eventId = eventId;
		this.eventName = eventName;
		this.statDate = statDate;
		this.productName = productName;
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
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getStatDate() {
		return statDate;
	}
	public void setStatDate(Date statDate) {
		this.statDate = statDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Event [userId=" + userId + ", userName=" + userName + ", provinceId=" + provinceId + ", provinceName="
				+ provinceName + ", age=" + age + ", eventId=" + eventId + ", eventName=" + eventName + ", statDate="
				+ statDate + ", productName=" + productName + "]";
	}
	
}
