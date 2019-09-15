package com.haoyun.personnelProject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haoyun.personnelProject.bean.UserBean;
import com.haoyun.personnelProject.service.UserService;
import com.haoyun.personnelProject.util.Result;
import com.haoyun.personnelProject.util.ResultType;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@RequestMapping("userlogon")
	public Result userlogon(@RequestParam(value="userName",required=true)String userName,
			@RequestParam(value="passWord",required=true)String passWord){
		
		UserBean userBean=userService.findUserByNC(userName, passWord);
		if(userBean != null) {
			return Result.resultSuccess(userBean);
		}
		
		return Result.resultError(userBean);
	}
	
	/**
	 * 用户注销
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@RequestMapping("logonOut")
	public Result logonOut(@RequestParam(value="userToken",required=true)String userToken){
		
		try {
			userService.updateUserByT(userToken);
			return Result.resultSuccess("退出登录成功");
		} catch (Exception e) {
			return Result.resultError("退出登录异常");
		}
	}
	
	/**
	 * 添加用户
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@RequestMapping("addUser")
	public Result addUser(@RequestParam(value="userName",required=true)String userName,
			@RequestParam(value="fullName",required=true)String fullName,
			@RequestParam(value="passWord",required=true)String passWord,
			@RequestParam(value="phone",required=false)String phone){
		
		
		Map<String,String> map=new HashMap<String,String>();	
		map.put("userName", userName);
		map.put("fullName", fullName);
		map.put("passWord", passWord);
		map.put("phone", phone);
		String code=userService.addUser(map);
		if(code==ResultType.ADD_SUCCESS) {
			return Result.resultSuccess(ResultType.ADD_SUCCESS);
		}
		return Result.resultError(ResultType.ADD_FAULT);	
					
	}
	
}
