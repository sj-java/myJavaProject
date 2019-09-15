package com.haoyun.personnelProject.serviceimp;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoyun.personnelProject.bean.ContractBean;
import com.haoyun.personnelProject.dao.ContractDao;
import com.haoyun.personnelProject.service.ContractService;
import com.haoyun.personnelProject.util.ResultType;

@Service
@Transactional
public class ContractServiceImp implements ContractService{
	
	@Autowired
	private ContractDao contractDao;
	
	@Override
	public String addContract(Map<String, String> map) {
		
		ContractBean bean=new ContractBean();
		bean.setId(UUID.randomUUID().toString().replaceAll("-",""));
		bean.setPersonnelId(map.get("personnelId"));
		bean.setContractName(map.get("contractName"));
		bean.setContractCode(map.get("contractCode"));
		bean.setSignDate(map.get("signDate"));
		bean.setIsLongContract(map.get("isLongContract"));
		bean.setExpireDate(map.get("expireDate"));
		bean.setRemark(map.get("remark"));
		try {
			contractDao.addContract(bean);
			return ResultType.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultType.ADD_FAULT;
		}
	}

	@Override
	public List<ContractBean> findContractByCon(Map<String, String> map) {
		
		return contractDao.findContractByCon(map);
	}

	@Override
	public String updateContractByCon(Map<String, String> map) {
		try {
			contractDao.updateContractByCon(map);
			return ResultType.UPDATE_SUCCESS;
		} catch (Exception e) {
			return ResultType.UPDATE_FAULT;
		}
	}
	
	

}
