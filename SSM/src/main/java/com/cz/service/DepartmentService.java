package com.cz.service;

import com.cz.model.Department;

import java.util.List;

public interface DepartmentService {
    public Department getDepartmentEmp(int deptId) throws Exception;
    public List<Department> getAllDepartment() throws  Exception;
}
