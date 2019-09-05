package com.haoyun.personnelProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haoyun.personnelProject.bean.Student;
import com.haoyun.personnelProject.service.StudentService;

@RestController
@RequestMapping("hello2")
public class HolleController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("sayHolle")
	public String  holle() {
		return "holle";
	}
	
	@RequestMapping("getStudentById")
	public ResponseEntity<Object>  get(@RequestParam("id")String id) {
		Student student=studentService.findStudentById(id);
		return new ResponseEntity<Object>(student, HttpStatus.OK);
	}
}
