package com.haoyun.personnelProject.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.haoyun.personnelProject.bean.PersonnelMessageBean;
import com.haoyun.personnelProject.service.PersonnelMessageService;
import com.haoyun.personnelProject.util.Result;
import com.haoyun.personnelProject.util.ResultType;

@RestController
@RequestMapping("/personnelMessage")
public class PersonnelMessageController {
	
	@Autowired
	private PersonnelMessageService personnelMessageService;
	
	/**
	 * 条件查询人员信息
	 * @param personnelName
	 * @param IDCard
	 * @return
	 */
	@RequestMapping("findPersonnelMessageByCon")
	public Result findPersonnelMessageByCon(@RequestParam(value="personnelName",required=false)String personnelName,
			@RequestParam(value="IDCard",required=false)String IDCard,
			@RequestParam(value="pageNum",required=false)Integer pageNum,
			@RequestParam(value="pageSize",required=false)Integer pageSize) {
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("personnelName", personnelName);
		map.put("IDCard", IDCard);
		PageInfo<PersonnelMessageBean> pageInfo=personnelMessageService.findPersonnerMessageByCon(map,pageNum,pageSize);
		return Result.resultSuccess(pageInfo);
	}
	
	/**
	 * 新增人员信息
	 * @param personnelName
	 * @param IDCard
	 * @return
	 */
	@RequestMapping("addPersonnelMessageByCon")
	public Result addPersonnelMessageByCon(@RequestParam(value="personnelName",required=true)String personnelName,
			@RequestParam(value="personnelSex",required=true)String personnelSex,
			@RequestParam(value="nation",required=true)String nation,
			@RequestParam(value="nativePlace",required=true)String nativePlace,
			@RequestParam(value="IDCard",required=true)String IDCard,
			@RequestParam(value="birthPlace",required=true)String birthPlace,
			@RequestParam(value="maritalStatus",required=true)String maritalStatus,
			@RequestParam(value="healthState",required=true)String healthState,
			@RequestParam(value="workUnit",required=true)String workUnit,
			@RequestParam(value="departmentCode",required=true)String departmentCode,
			@RequestParam(value="jobName",required=true)String jobName,
			@RequestParam(value="jobType",required=true)String jobType,
			@RequestParam(value="personnelType",required=true)String personnelType,
			@RequestParam(value="onTheJobState",required=true)String onTheJobState,
			@RequestParam(value="entryDate",required=true)String entryDate,
			@RequestParam(value="leaveDate",required=false)String leaveDate,
			@RequestParam(value="politicsStatus",required=true)String politicsStatus,
			@RequestParam(value="startWorkTime",required=false)String startWorkTime,
			@RequestParam(value="fullTimeAcademic",required=false)String fullTimeAcademic,
			@RequestParam(value="fullTimeDegree",required=false)String fullTimeDegree,
			@RequestParam(value="fullTimeSchool",required=false)String fullTimeSchool,
			@RequestParam(value="fullTimeMajor",required=false)String fullTimeMajor,
			@RequestParam(value="inServiceEducationAcademic",required=false)String inServiceEducationAcademic,
			@RequestParam(value="inServiceEducationDegree",required=false)String inServiceEducationDegree,
			@RequestParam(value="inServiceEducationSchool",required=false)String inServiceEducationSchool,
			@RequestParam(value="inServiceEducationMajor",required=false)String inServiceEducationMajor,
			@RequestParam(value="joinCommunistPartyTime",required=false)String joinCommunistPartyTime,
			@RequestParam(value="joinLeagueMemberTime",required=false)String joinLeagueMemberTime,
			@RequestParam(value="joinAnyDemocratsTime",required=false)String joinAnyDemocratsTime,
			@RequestParam(value="reviewState",required=true)String reviewState,
			@RequestParam(value="usable",required=true)String usable) {
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("personnelName", personnelName);
		map.put("personnelSex", personnelSex);
		map.put("nation", nation);
		map.put("nativePlace", nativePlace);
		map.put("IDCard", IDCard);
		map.put("birthPlace", birthPlace);
		map.put("maritalStatus", maritalStatus);
		map.put("healthState", healthState);
		map.put("workUnit", workUnit);
		map.put("departmentCode", departmentCode);
		map.put("jobName", jobName);
		map.put("jobType", jobType);
		map.put("personnelType", personnelType);
		map.put("onTheJobState", onTheJobState);
		map.put("entryDate", entryDate);
		map.put("leaveDate", leaveDate);
		map.put("politicsStatus", politicsStatus);
		map.put("startWorkTime", startWorkTime);
		map.put("fullTimeAcademic", fullTimeAcademic);
		map.put("fullTimeDegree", fullTimeDegree);
		map.put("fullTimeSchool", fullTimeSchool);
		map.put("fullTimeMajor", fullTimeMajor);
		map.put("inServiceEducationAcademic", inServiceEducationAcademic);
		map.put("inServiceEducationDegree", inServiceEducationDegree);
		map.put("inServiceEducationSchool", inServiceEducationSchool);
		map.put("inServiceEducationMajor", inServiceEducationMajor);
		map.put("joinCommunistPartyTime", joinCommunistPartyTime);
		map.put("joinLeagueMemberTime", joinLeagueMemberTime);
		map.put("joinAnyDemocratsTime", joinAnyDemocratsTime);
		map.put("reviewState", reviewState);
		map.put("usable", usable);
		try {
			String msg=personnelMessageService.addPersonnerMessage(map);
			return Result.resultMsg("", msg);
		} catch (Exception e) {
			
			return Result.resultError(ResultType.ADD_FAULT);
		}
		
	}
	

}
