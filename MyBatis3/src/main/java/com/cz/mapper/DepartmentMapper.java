package com.cz.mapper;

import com.cz.model.Department;

import java.util.List;

public interface DepartmentMapper {
    public List<Department> getDepartmentTypeTwo();

    public List<Department> getDepartmentEmp(int deptId);

    public List<Department> getDepartmentEmpAll(int deptId);
}
