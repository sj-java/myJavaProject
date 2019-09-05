package com.haoyun.personnelProject.service;

import org.apache.ibatis.annotations.Param;

import com.haoyun.personnelProject.bean.Student;

public interface StudentService {
	
	public Student findStudentById(String id);
	
}
