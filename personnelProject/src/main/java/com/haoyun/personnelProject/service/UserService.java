package com.haoyun.personnelProject.service;

import java.util.Map;

import com.haoyun.personnelProject.bean.UserBean;

public interface UserService {
	
	public UserBean findUserById(String id);
	
	public UserBean findUserByName(String name);

	
	public String addUser(Map<String,String> map);
	
	public UserBean findUserByNC(String name,String passWord);
	
	public void updateUserByT(String token);
	
	public boolean findUserByToken(String token);
}
