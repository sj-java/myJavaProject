package com.haoyun.personnelProject.service;

import java.util.List;
import java.util.Map;

import com.haoyun.personnelProject.bean.ContractBean;
import com.haoyun.personnelProject.util.ResultType;

public interface ContractService {
	/**
	 * 新增合同
	 */
	String addContract(Map<String, String> map);
	/**
	 * 条件查询合同
	 */
	List<ContractBean> findContractByCon(Map<String,String> map);
	/**
	 * 更新合同
	 */
	String updateContractByCon(Map<String,String> map);
}
