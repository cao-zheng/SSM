package com.cz.model;

import lombok.Data;

@Data
public class Admin implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private int deptId;
	
	private String name;
	
	private String deptName;
}
