package com.haoyun.personnelProject.serviceimp;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoyun.personnelProject.bean.AnnexBean;
import com.haoyun.personnelProject.dao.AnnexDao;
import com.haoyun.personnelProject.service.AnnexService;
import com.haoyun.personnelProject.util.ResultType;

@Service
@Transactional
public class AnnexServiceImp implements AnnexService{
	
	@Autowired
	private AnnexDao annexDao;
	/**
	 * 查询所有附件
	 */
	@Override
	public List<AnnexBean> findAnnexBean(Map<String,String> map) {
		
		return annexDao.findAnnexBean(map);
	}
	
	/**
	 * 新增附件
	 */
	@Override
	public String addAnnexBean(Map<String, String> map) {
		
		AnnexBean bean=new AnnexBean();
		bean.setId(UUID.randomUUID().toString().replaceAll("-",""));
		bean.setBelongId(map.get("belongId"));
		bean.setAnnexName(map.get("annexName"));
		bean.setLastName(map.get("lastName"));
		bean.setAnnexUrl(map.get("annexUrl"));
		bean.setUploadDate(map.get("uploadDate"));
		try {
			annexDao.addAnnexBean(bean);
			return ResultType.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultType.ADD_FAULT;
		}
	}
	
	/**
	 * 删除附件
	 */
	@Override
	public String deleteAnnexBean(String id) {
		try {
			annexDao.deleteAnnexBean(id);
			return ResultType.REMOVE_SUCCESS;
		} catch (Exception e) {
			return ResultType.REMOVE_FAULT;
		}
	}
		
}
