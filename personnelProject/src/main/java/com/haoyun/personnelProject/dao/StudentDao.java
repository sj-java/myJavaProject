package com.haoyun.personnelProject.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.haoyun.personnelProject.bean.Student;


public interface StudentDao {
	
	public Student findStudentById(@Param("id")String id);
}
