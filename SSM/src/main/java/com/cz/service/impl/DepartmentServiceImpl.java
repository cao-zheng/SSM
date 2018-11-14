package com.cz.service.impl;
import com.cz.mapper.DepartmentMapper;
import com.cz.model.Department;
import com.cz.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource(name = "departmentMapper")
    private DepartmentMapper departmentMapper;

    public List<Department> getAllDepartment() throws  Exception{
        return departmentMapper.getAllDepartment();
    }
    public Department getDepartmentEmp(int deptId) throws Exception{
       return departmentMapper.getDepartmentEmp(deptId);
    }
}
