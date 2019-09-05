package com.haoyun.personnelProject.bean;

public class UserBean {
	//用户ID
	private String id;
	//用户名称
	private String userName;
	//用户登录密码
	private String passWord;
	//姓名
	private String fullName;
	//用户电话号码
	private String phone;
	//用户验证
	private String userToken;
	//最近一次访问时间
	private String lastCallTime;
	//用户所在部门ID
	private String departIdOfUser;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getLastCallTime() {
		return lastCallTime;
	}
	public void setLastCallTime(String lastCallTime) {
		this.lastCallTime = lastCallTime;
	}
	public String getDepartIdOfUser() {
		return departIdOfUser;
	}
	public void setDepartIdOfUser(String departIdOfUser) {
		this.departIdOfUser = departIdOfUser;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
