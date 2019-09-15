package com.haoyun.personnelProject.service;

import java.util.List;
import java.util.Map;

import com.haoyun.personnelProject.bean.DepartmentBean;

public interface DepartmentService {
	/**
	 * 添加部门
	 * @param departmentBean
	 */
	String addDepartment(Map<String,String> map);
	/**
	 * 条件查询部门
	 * @param map
	 * @return
	 */
	List<DepartmentBean> findDepartmentByCon(Map<String,String> map);
	/**
	 * 条件更新部门
	 * @param map
	 * @return
	 */
	void updateDepartmentByCon(Map<String,String> map);

}
