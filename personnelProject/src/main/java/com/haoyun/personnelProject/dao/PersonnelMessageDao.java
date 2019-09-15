package com.haoyun.personnelProject.dao;

import java.util.List;
import java.util.Map;

import com.haoyun.personnelProject.bean.PersonnelMessageBean;

public interface PersonnelMessageDao {
	/**
	 * 条件查询人员信息
	 * @param map
	 * @return
	 */
	List<PersonnelMessageBean> findPersonnerMessageByCon(Map<String,String> map);
	/**
	 * 新增人员基本信息
	 * 
	 */
	void addPersonnerMessage(PersonnelMessageBean personnelMessageBean);
	/**
	 * 更新人员基本信息
	 * @param map
	 */
	void updatePersonnelMessage(Map<String,String> map);
}
