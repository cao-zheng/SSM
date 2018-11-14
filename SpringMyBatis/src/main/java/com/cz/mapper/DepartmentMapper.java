package com.cz.mapper;

import com.cz.model.Department;

public interface DepartmentMapper {
    public Department getDepartmentById(int deptId);

    public Department getDeptById(int dept);
}
