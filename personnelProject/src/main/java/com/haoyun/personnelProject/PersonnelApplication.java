package com.haoyun.personnelProject;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan(basePackages="com.haoyun.personnelProject.dao")
public class PersonnelApplication {
	
    public static void main( String[] args )
    {
        SpringApplication.run(PersonnelApplication.class, args);
    }
 
}
