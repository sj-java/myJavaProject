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
@RequestMapping("/personnal")
public class SystemController {
	
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@RequestMapping("userlogon")
	public Result userlogon(@RequestParam("userName")String userName,
			@RequestParam("passWord")String passWord){
		
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
	public ResponseEntity<Object> logonOut(@RequestParam("userToken")String token){
		
		try {
			userService.updateUserByT(token);
			return new ResponseEntity<Object>("注销成功", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("注销失败", HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * 添加用户
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@RequestMapping("addUser")
	public Result addUser(@RequestParam("userBean")String userBean){
		
		JSONObject OBJ=JSONObject.fromObject(userBean);
		Map<String,String> map=new HashMap<String,String>();	
		map=(Map)OBJ;
		String code=userService.addUser(map);
		if(code==ResultType.ADD_SUCCESS) {
			return Result.resultSuccess(ResultType.ADD_SUCCESS);
		}
		return Result.resultError(ResultType.ADD_FAULT);	
					
	}
	
}
