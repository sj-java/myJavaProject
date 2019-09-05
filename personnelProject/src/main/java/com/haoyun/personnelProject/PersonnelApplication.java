package com.haoyun.personnelProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
