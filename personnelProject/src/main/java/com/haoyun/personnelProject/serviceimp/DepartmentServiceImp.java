package com.haoyun.personnelProject.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoyun.personnelProject.bean.DepartmentBean;
import com.haoyun.personnelProject.dao.DepartmentDao;
import com.haoyun.personnelProject.service.DepartmentService;
import com.haoyun.personnelProject.util.ResultType;
@Service
@Transactional
public class DepartmentServiceImp implements DepartmentService{
	
	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public String addDepartment(Map<String, String> map) {
		
		DepartmentBean departmentBean=new DepartmentBean();
		departmentBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
		departmentBean.setDepartmentName(map.get("departmentName"));
		departmentBean.setDepartmentCode(map.get("departmentCode"));
		departmentBean.setDepartmentRank(map.get("departmentRank"));
		departmentBean.setDepartmentDescribe(map.get("departmentDescribe"));
		departmentBean.setFatherDepartmentId(map.get("fatherDepartmentId"));
		departmentBean.setDepartmentState(map.get("departmentState"));
		
		Map<String,String> nameMap=new HashMap<String,String>();
		nameMap.put("departmentName", map.get("departmentName"));
		if(departmentDao.findDepartmentByCon(nameMap).size()>0) {
			return ResultType.ADD_FAULT;
		}
		
		Map<String,String> codeMap=new HashMap<String,String>();
		nameMap.put("departmentCode", map.get("departmentCode"));		
		if(departmentDao.findDepartmentByCon(codeMap).size()>0) {
			return ResultType.ADD_FAULT;
		}		
		
		departmentDao.addDepartment(departmentBean);
		return ResultType.ADD_SUCCESS;
	}

	@Override
	public List<DepartmentBean> findDepartmentByCon(Map<String, String> map) {
		
		return departmentDao.findDepartmentByCon(map);
	}

	@Override
	public void updateDepartmentByCon(Map<String, String> map) {
		
		departmentDao.updateDepartmentByCon(map);
	}

}
