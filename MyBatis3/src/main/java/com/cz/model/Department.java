package com.cz.model;

import lombok.Data;

import java.util.List;

@Data
public class Department {

	private int deptId;

	private String deptName;

	private List<Employee> emps;

}
