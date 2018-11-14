package com.cz.model;

import lombok.Data;

import java.util.List;

@Data
public class Department implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

	private int deptId;

	private String deptName;

	private List<Employee> emps;
}
