package com.cz.service.impl;

import com.cz.mapper.EmployeeMapper;
import com.cz.model.Employee;
import com.cz.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource(name = "employeeMapper")
    private EmployeeMapper employeeMapper;
    public PageInfo<Employee> getEmpPage(int pageNum,int pageSize) throws Exception{
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> emps = employeeMapper.getEmpPage();
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps);
        return pageInfo;
    }
    public Employee getEmployee(int id) throws Exception{
        return employeeMapper.getEmpById(id);
    }
    public void add(Employee employee) throws  Exception{
        employeeMapper.addEmp(employee);
    }
    public void update(Employee employee) throws  Exception{
        employeeMapper.updateEmp(employee);
    }
    public void deleteEmp(int id) throws Exception{
        employeeMapper.deleteEmp(id);
    }
}
