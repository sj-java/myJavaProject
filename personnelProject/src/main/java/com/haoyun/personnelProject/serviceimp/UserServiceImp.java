package com.haoyun.personnelProject.serviceimp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoyun.personnelProject.bean.UserBean;
import com.haoyun.personnelProject.dao.UserDao;
import com.haoyun.personnelProject.service.UserService;
import com.haoyun.personnelProject.util.MD5Utils;
import com.haoyun.personnelProject.util.ResultType;
import com.haoyun.personnelProject.util.TokenProccessor;
@Service
@Transactional
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;
	/**
	 * 通过ID查找用户
	 */
	@Override
	public UserBean findUserById(String id) {
		
		return userDao.findUserById(id);
	}
	/**
	 * 通过用户名查找用户
	 */
	@Override
	public UserBean findUserByName(String name) {
		
		return userDao.findUserByName(name);
	}
	/**
	 * 新增用户
	 */
	@Override
	public String addUser(Map<String,String> map) {
		String id=UUID.randomUUID().toString().replaceAll("-","");
		String name=map.get("name");
		String fullName=map.get("fullName");
		String passWord=map.get("passWord");
		String phone=map.get("phone");
		if(userDao.findUserByName(name) != null) {
			return ResultType.ADD_FAULT;
		}
		UserBean bean=new UserBean();
		bean.setId(id);
		bean.setUserName(name);
		bean.setPassWord(MD5Utils.stringToMD5(passWord));
		bean.setFullName(fullName);
		bean.setPhone(phone);
		userDao.addUser(bean);
		return ResultType.ADD_SUCCESS;
	}
	/**
	 * 用户登录
	 */
	@Override
	public UserBean findUserByNC(String name, String passWord) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("userName", name);
		map.put("passWord", MD5Utils.stringToMD5(passWord));
		UserBean userBean=userDao.findUserByNC(map);
		if(userBean != null) {
			Map<String,String> tmap=new HashMap<String,String>();
			tmap.put("userToken", TokenProccessor.getInstance().makeToken());
			tmap.put("userName",name);
			userDao.updateUserToken(tmap);	
			return userDao.findUserById(userBean.getId());
		}
		return null;
	}
	/**
	 * 注销登录
	 */
	@Override
	public void updateUserByT(String token) {
		
		userDao.updateUserCancel(token);
	
	}
	/**
	 * 访问验证
	 */
	@Override
	public boolean findUserByToken(String token) {
		Map<String,String> map=new HashMap<>();
		map.put("userToken", token);
		if(userDao.findUserByToken(map)!=null) {
			return true;
		}
		return false;
	}

}
