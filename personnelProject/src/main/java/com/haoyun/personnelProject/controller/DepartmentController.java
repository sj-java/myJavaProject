package com.haoyun.personnelProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haoyun.personnelProject.bean.DepartmentBean;
import com.haoyun.personnelProject.service.DepartmentService;
import com.haoyun.personnelProject.util.Result;
import com.haoyun.personnelProject.util.ResultType;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	/**
	 * 新增部门
	 * @param departmentName
	 * @param departmentCode
	 * @param departmentRank
	 * @param departmentDescribe
	 * @param fatherDepartmentId
	 * @param departmentState
	 * @return
	 */
	@RequestMapping("addDepartment")
	public Result addDepartment(@RequestParam(value="departmentName",required=true)String departmentName,
			@RequestParam(value="departmentCode",required=true)String departmentCode,
			@RequestParam(value="departmentRank",required=true)String departmentRank,
			@RequestParam(value="departmentDescribe",required=false)String departmentDescribe,
			@RequestParam(value="fatherDepartmentId",required=false)String fatherDepartmentId,
			@RequestParam(value="departmentState",required=true)String departmentState) {
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("departmentName", departmentName);
		map.put("departmentCode", departmentCode);
		map.put("departmentRank", departmentRank);
		map.put("departmentDescribe", departmentDescribe);
		map.put("fatherDepartmentId", fatherDepartmentId);
		map.put("departmentState",departmentState);
		
		String msg=departmentService.addDepartment(map);
		return Result.resultMsg("", msg);
				
	}
	/**
	 * 条件查询部门
	 * @return
	 */
	@RequestMapping("findDepartmentByCon")
	public Result findDepartmentByCon(@RequestParam(value="departmentId",required=false)String departmentId,
			@RequestParam(value="departmentName",required=false)String departmentName,
			@RequestParam(value="departmentCode",required=false)String departmentCode,
			@RequestParam(value="departmentState",required=false)String departmentState) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("departmentId", departmentId);
		map.put("departmentName", departmentName);
		map.put("departmentCode", departmentCode);
		map.put("departmentState", departmentState);
		List<DepartmentBean> list=departmentService.findDepartmentByCon(map);
		return Result.resultSuccess(list);
	}
	/**
	 * 条件编辑部门
	 * @return
	 */
	@RequestMapping("updateDepartmentByCon")
	public Result updateDepartmentByCon(@RequestParam(value="departmentId",required=false)String departmentId,
			@RequestParam(value="departmentState",required=false)String departmentState) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("departmentId", departmentId);
		map.put("departmentState", departmentState);
		try {
			departmentService.updateDepartmentByCon(map);
			return Result.resultSuccess(ResultType.UPDATE_SUCCESS);	
		} catch (Exception e) {
			departmentService.updateDepartmentByCon(map);
			return Result.resultSuccess(ResultType.UPDATE_FAULT);	
		}
	
	}
}
