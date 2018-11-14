package com.cz.service;

import com.cz.model.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
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

    public PageInfo<Employee> getEmpPage(int pageNum,int pageSize);
}
