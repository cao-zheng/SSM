package com.cz.mapper;

import com.cz.model.Department;

import java.util.List;

public interface DepartmentMapper {
    public Department getDepartmentEmp(int deptId);

    public Department getDepartmentLazy(int deptId);

    public List<Department> getAllDepartment();
}
