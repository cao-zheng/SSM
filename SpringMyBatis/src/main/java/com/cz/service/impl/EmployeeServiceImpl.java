package com.cz.service.impl;

import com.cz.mapper.EmployeeMapper;
import com.cz.model.Employee;
import com.cz.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("employeeService")
@Data
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getEmpByIdLazyLoad(int empId) {
        return employeeMapper.getEmpByIdLazyLoad(empId);
    }

    public List<Employee> getEmpsByDeptIdLazyLoad(int deptId) {
        return employeeMapper.getEmpsByDeptIdLazyLoad(deptId);
    }

    public PageInfo<Employee> getEmpPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> emps =  employeeMapper.getEmpPage();
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps);
        return pageInfo;
    }
}
