package com.cz.mapper;

import com.cz.dao.EmpDto;
import com.cz.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 根据员工id查询员工信息
     * @param empId
     * @return
     */
    public Employee getEmpByIdLazyLoad(int empId);
    /**
     * 根据部门id查询员工们
     * @param deptId
     * @return
     */
    public List<Employee> getEmpsByDeptIdLazyLoad(int deptId);
}
