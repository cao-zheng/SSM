package com.cz.action;

import com.cz.model.Department;
import com.cz.model.Employee;
import com.cz.service.DepartmentService;
import com.cz.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class EmployeeAction {
    public static final int pageSize = 10;

    @Resource(name = "employeeService")
    private EmployeeService employeeService;
    @Resource(name="departmentService")
    private DepartmentService departmentService;
/*    @Resource(name="messageSource")
    private ResourceBundleMessageSource messageSource;*/
    @RequestMapping("/home")
    public String home(){
        return "redirect:/emps/1";
    }
    @RequestMapping("/i18n")
    public String i18n(Locale locale, HttpServletRequest request){
        //从request上下文中获取资源文件的名称
        RequestContext requestContext = new RequestContext(request);
        String user = requestContext.getMessage("i18n.user");
/*        String user2 = messageSource.getMessage("i18n.user", null, locale);*/
        System.out.println("user" + user);
/*        System.out.println("user2" + user2);*/
        return "i18n";
    }
    @RequestMapping("/json")
    public String json(){
        return "json";
    }
    @RequestMapping(value="/emps/{pageNum}",method = RequestMethod.GET)
    public String pageForEmployee(@PathVariable("pageNum")int pageNum, Map<String,Object> map) throws Exception {
        PageInfo<Employee> empsPage = employeeService.getEmpPage(pageNum,pageSize);
        //员工数据
        map.put("emps",empsPage.getList());
        //第几页
        map.put("emsPageNum",empsPage.getPageNum());
        //多少页
        map.put("emsPages",empsPage.getPages());
        //总数
        map.put("emsTotal",empsPage.getTotal());
        return "employee_view";
    }
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String LoadEmployeeAddForm(Map<String,Object> map) throws Exception {
        List<Department> departments = departmentService.getAllDepartment();
        map.put("departments",departments);
        map.put("employee",new Employee());
        return "employee_add";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String LoadEmployeeEditForm(@PathVariable("id")int id, Map<String,Object> map,String fdmodelName) throws Exception{
        Employee employee = employeeService.getEmployee(id);
        List<Department> departments = departmentService.getAllDepartment();
        map.put("departments",departments);
        map.put("employee",employee);
        return "employee_edit";
    }
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmployee(@Valid Employee employee, BindingResult result,Map<String,Object> map) throws Exception {
        if(this.validate(employee,result,map)==true){
            return "employee_add";
        }
        employeeService.add(employee);
        return "redirect:/emps/1";
    }
    @RequestMapping(value = "/emp",method=RequestMethod.PUT)
    public String editEmployee(@Valid Employee employee,BindingResult bindingResult,Map<String,Object> map) throws Exception{
        if(this.validate(employee,bindingResult,map)==true){
            return "employee_edit";
        }
        employeeService.update(employee);
        return "redirect:/emps/1";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id")int id) throws  Exception{
        employeeService.deleteEmp(id);
        return "redirect:/emps/1";
    }
    @RequestMapping(value = "/emp/test",method = RequestMethod.POST)
    public String testConverter(Date date){
        System.out.println(date);
        return "redirect:/emps/1";
    }

    /**
     * 不自动绑定对象中的email属性，可以取消页面的提交属性
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields("email");
    }
    private boolean validate(Employee employee,BindingResult bindingResult,Map<String,Object> map) throws Exception{
        if(bindingResult.getErrorCount()>0){
            System.out.println("您填写的表单不正确");
            for (FieldError fieldError:bindingResult.getFieldErrors()){
                System.out.println(fieldError.getField()+":"+fieldError.getDefaultMessage());
                List<Department> departments = departmentService.getAllDepartment();
                map.put("departments",departments);
                map.put("employee",employee);
                return true;
            }
        }
        return false;
    }
}
