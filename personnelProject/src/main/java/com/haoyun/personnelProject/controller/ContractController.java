package com.haoyun.personnelProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haoyun.personnelProject.bean.ContractBean;
import com.haoyun.personnelProject.service.ContractService;
import com.haoyun.personnelProject.util.Result;

@RestController
@RequestMapping("/contract")
public class ContractController {
	
	@Autowired
	private ContractService contractService;
	/**
	 * 添加人员合同
	 * @return
	 */
	@RequestMapping("addContract")
	public Result addContract(@RequestParam(value="personnelId",required=true)String personnelId,
			@RequestParam(value="contractName",required=true)String contractName,
			@RequestParam(value="contractCode",required=true)String contractCode,
			@RequestParam(value="signDate",required=true)String signDate,
			@RequestParam(value="isLongContract",required=true)String isLongContract,
			@RequestParam(value="expireDate",required=false)String expireDate,
			@RequestParam(value="remark",required=false)String remark) {
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("personnelId", personnelId);
		map.put("contractName",contractName);
		map.put("contractCode",contractCode);
		map.put("signDate",signDate);
		map.put("isLongContract",isLongContract);
		map.put("expireDate",expireDate);
		map.put("remark",remark);
		String msg=contractService.addContract(map);
		return Result.resultMsg(null, msg);
	}
	/**
	 * 条件查询人员合同
	 * @return
	 */
	@RequestMapping("findContractByCon")
	public Result findContractByCon(@RequestParam(value="personnelId",required=false)String personnelId) {
		Map<String,String> map=new HashMap<String, String>();
		map.put("personnelId", personnelId);
		try {
			List<ContractBean> list=contractService.findContractByCon(map);
			return Result.resultSuccess(list);
		} catch (Exception e) {
			return Result.resultError(null);
		}
	}
	/**
	 * 更新查询人员合同
	 * @return
	 */
	@RequestMapping("updateContractByCon")
	public Result updateContractByCon(@RequestParam(value="id",required=true)String id,
			@RequestParam(value="isLongContract",required=false)String isLongContract,
			@RequestParam(value="expireDate",required=false)String expireDate) {
		Map<String,String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("isLongContract", isLongContract);
		map.put("expireDate", expireDate);
		String msg=contractService.updateContractByCon(map);
		return Result.resultMsg(null, msg);
	}
}
