package com.cz.mapper;

import com.cz.model.Department;
import com.cz.model.Employee;

import java.util.List;

public interface DepartmentMapper {
    public Department getDepartmentById(int deptId);

    public Department getDeptById(int dept);
}
