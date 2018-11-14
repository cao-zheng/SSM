package com.cz.mapper;

import com.cz.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> getEmpPage();

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public Employee getEmpById(int id);

    public void deleteEmp(int id);

}
