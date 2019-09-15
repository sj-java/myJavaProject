package com.haoyun.personnelProject.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.haoyun.personnelProject.bean.AnnexBean;

public interface AnnexDao {
	
	List<AnnexBean> findAnnexBean(Map<String,String> map);
	
	void addAnnexBean(AnnexBean annexBean);
	
	void deleteAnnexBean(@Param("id")String id);
}
