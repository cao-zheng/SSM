package com.cz.service;

import com.cz.model.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    public PageInfo<Employee> getEmpPage(int pageNum, int pageSize) throws Exception;

    public void add(Employee employee) throws  Exception;

    public void update(Employee employee) throws  Exception;

    public Employee getEmployee(int id) throws Exception;

    public void deleteEmp(int id) throws Exception;
}
