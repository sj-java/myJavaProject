package com.haoyun.personnelProject.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.haoyun.personnelProject.bean.PersonnelMessageBean;

public interface PersonnelMessageService {
	/**
	 * 条件查询人员信息
	 * @param map
	 * @return
	 */
	PageInfo<PersonnelMessageBean>  findPersonnerMessageByCon(Map<String,String> map,Integer pageNum,Integer pageSize);
	/**
	 * 新增人员基本信息
	 * 
	 */
	String addPersonnerMessage(Map<String,String> map);
	/**
	 * 更新人员基本信息
	 * @param map
	 */
	void updatePersonnelMessage(Map<String,String> map);
}
