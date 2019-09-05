package com.haoyun.personnelProject.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoyun.personnelProject.bean.Student;
import com.haoyun.personnelProject.dao.StudentDao;
import com.haoyun.personnelProject.service.StudentService;
@Service
@Transactional
public class StudentServiceImp implements StudentService{
	@Autowired
	private StudentDao studentDao;
	@Override
	public Student findStudentById(String id) {
		
		return studentDao.findStudentById(id);
	}

}
