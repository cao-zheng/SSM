package com.cz.mapper;

import com.cz.dao.EmpDto;
import com.cz.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> getEmpByEmpDto(EmpDto empDto);

    public List<Employee> getEmpByDepartmentLazy(int deptId);
}
