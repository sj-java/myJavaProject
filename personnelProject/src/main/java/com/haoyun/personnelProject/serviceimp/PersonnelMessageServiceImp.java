package com.haoyun.personnelProject.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoyun.personnelProject.bean.PersonnelMessageBean;
import com.haoyun.personnelProject.dao.PersonnelMessageDao;
import com.haoyun.personnelProject.service.PersonnelMessageService;
import com.haoyun.personnelProject.util.ResultType;
@Service
@Transactional
public class PersonnelMessageServiceImp implements PersonnelMessageService{
	
	
	@Autowired
	private PersonnelMessageDao personnelMessageDao;
	
	@Override
	public PageInfo<PersonnelMessageBean> findPersonnerMessageByCon(Map<String, String> map,Integer pageNum,Integer pageSize) {
		if(pageNum!=null && pageSize!=null) {
			PageHelper.startPage(pageNum,pageSize);
			List<PersonnelMessageBean> list=personnelMessageDao.findPersonnerMessageByCon(map);
			return new PageInfo<PersonnelMessageBean>(list);
		}
		List<PersonnelMessageBean> plist=personnelMessageDao.findPersonnerMessageByCon(map);
		return new PageInfo<PersonnelMessageBean>(plist);
	}

	@Override
	public String addPersonnerMessage(Map<String,String> map) {
		
		PersonnelMessageBean personnelMessageBean=new PersonnelMessageBean();
		personnelMessageBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
		personnelMessageBean.setPersonnelName(map.get("personnelName"));
		personnelMessageBean.setPersonnelSex(map.get("personnelSex"));
		personnelMessageBean.setNation(map.get("nation"));
		personnelMessageBean.setNativePlace(map.get("nativePlace"));
		personnelMessageBean.setIDCard(map.get("IDCard"));
		personnelMessageBean.setBirthPlace(map.get("birthPlace"));
		personnelMessageBean.setMaritalStatus(map.get("maritalStatus"));
		personnelMessageBean.setHealthState(map.get("healthState"));
		personnelMessageBean.setWorkUnit(map.get("workUnit"));
		personnelMessageBean.setDepartmentCode(map.get("departmentCode"));
		personnelMessageBean.setJobName(map.get("jobName"));
		personnelMessageBean.setJobType(map.get("jobType"));
		personnelMessageBean.setPersonnelType(map.get("personnelType"));
		personnelMessageBean.setOnTheJobState(map.get("onTheJobState"));
		personnelMessageBean.setEntryDate(map.get("entryDate"));
		personnelMessageBean.setLeaveDate(map.get("leaveDate"));
		personnelMessageBean.setPoliticsStatus(map.get("politicsStatus"));
		personnelMessageBean.setStartWorkTime(map.get("startWorkTime"));
		personnelMessageBean.setFullTimeAcademic(map.get("fullTimeAcademic"));
		personnelMessageBean.setFullTimeDegree(map.get("fullTimeDegree"));
		personnelMessageBean.setFullTimeSchool(map.get("fullTimeSchool"));
		personnelMessageBean.setFullTimeMajor(map.get("fullTimeMajor"));
		personnelMessageBean.setInServiceEducationAcademic(map.get("inServiceEducationAcademic"));
		personnelMessageBean.setInServiceEducationDegree(map.get("inServiceEducationDegree"));
		personnelMessageBean.setInServiceEducationSchool(map.get("inServiceEducationSchool"));
		personnelMessageBean.setInServiceEducationMajor(map.get("inServiceEducationMajor"));
		personnelMessageBean.setJoinCommunistPartyTime(map.get("joinCommunistPartyTime"));
		personnelMessageBean.setJoinLeagueMemberTime(map.get("joinLeagueMemberTime"));
		personnelMessageBean.setJoinAnyDemocratsTime(map.get("joinAnyDemocratsTime"));
		personnelMessageBean.setReviewState(map.get("reviewState"));
		personnelMessageBean.setUsable(map.get("usable"));
		
		Map<String,String> cardMap=new HashMap<String,String>();
		cardMap.put("IDCard", map.get("IDCard"));
		if(personnelMessageDao.findPersonnerMessageByCon(cardMap).size()>0) {
			return ResultType.ADD_FAULT;
		}
		
		personnelMessageDao.addPersonnerMessage(personnelMessageBean);
		return ResultType.ADD_SUCCESS;
	}

	@Override
	public void updatePersonnelMessage(Map<String, String> map) {
		
		personnelMessageDao.updatePersonnelMessage(map);
	}
	

}
