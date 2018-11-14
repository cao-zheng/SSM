package com.cz.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private int empId;
	
	private String empName;
	
	private String gender;
	
	private String email;
	
	private BigDecimal salary;
	
	private String jobTitle;
	
	private int deptId;

	private Department dept;
}
