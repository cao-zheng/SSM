package com.cz.action;

import com.cz.bean.JsonResult;
import com.cz.model.Employee;
import com.cz.service.DepartmentService;
import com.cz.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/json")
public class RestfulJsonAction {
    public static final int pageSize = 10;

    @Resource(name = "employeeService")
    private EmployeeService employeeService;

    @Resource(name="departmentService")
    private DepartmentService departmentService;

    @ResponseBody
    @RequestMapping(value="/emps/{pageNum}",method = RequestMethod.GET)
    public JsonResult pageForEmployee(@PathVariable("pageNum")int pageNum) throws Exception {
        PageInfo<Employee> empsPage = employeeService.getEmpPage(pageNum,pageSize);
          return JsonResult.getJsonResult(1,"成功返回结果集",empsPage.getList());
    }
}
