package com.haoyun.personnelProject.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.haoyun.personnelProject.bean.AnnexBean;

public interface AnnexService {

	List<AnnexBean> findAnnexBean(Map<String,String> map);
	
	String addAnnexBean(Map<String,String> map);
	
	String deleteAnnexBean(@Param("id")String id);
}
