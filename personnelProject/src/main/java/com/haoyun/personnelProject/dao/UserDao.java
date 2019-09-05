package com.haoyun.personnelProject.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.haoyun.personnelProject.bean.UserBean;
/**
 * 用户实体类
 * @author Admin
 *
 */
public interface UserDao {
	/**
	 * 通过ID查询用户
	 * @param id
	 * @return
	 */
	public UserBean findUserById(@Param("id")String id);
	/**
	 * 通过姓名查询用户
	 * @param name
	 * @return
	 */
	public UserBean findUserByName(@Param("name")String name);
	
	/**
	 * 新增用户
	 * @param user
	 */
	public void addUser(UserBean user);
	/**
	 * 通过用户名密码查询用户
	 * @param map
	 * @return
	 */
	public UserBean findUserByNC(Map<String,String> map);
	/**
	 * 通过用户名查询token
	 * @param map
	 * @return
	 */
	public UserBean findUserByToken(Map<String,String> map);
	/**
	 * 更新token
	 * @param map
	 */
	public void updateUserToken(Map<String,String> map);
	/**
	 * 滞空token
	 * @param userToken
	 */
	public void updateUserCancel(@Param("userToken")String userToken);
}
