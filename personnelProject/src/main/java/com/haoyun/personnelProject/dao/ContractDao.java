package com.haoyun.personnelProject.dao;

import java.util.List;
import java.util.Map;

import com.haoyun.personnelProject.bean.ContractBean;

/**
 * 合同DAO
 * @author Admin
 *
 */
public interface ContractDao {
	/**
	 * 新增合同
	 */
	void addContract(ContractBean contractBean);
	/**
	 * 条件查询合同
	 */
	List<ContractBean> findContractByCon(Map<String,String> map);
	/**
	 * 更新合同
	 */
	void updateContractByCon(Map<String,String> map);
}
