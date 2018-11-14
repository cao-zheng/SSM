import com.cz.model.Employee;
import com.cz.model.User;
import com.cz.service.DepartmentService;
import com.cz.service.EmployeeService;
import com.cz.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class Test {
    @Resource(name = "userService")
    private UserService userService;
    @org.junit.Test
    public void testUserService() throws Exception {
        User user = new User();
        user.setUserName("admin");
        user.setPwdKey("");
        user.setMobile("13123123");
        user.setCreateTime(new Date());
        user.setPassword("abcABC123");
        userService.addUser(user);
    }
    @Resource(name = "employeeService")
    private EmployeeService employeeService;
    @org.junit.Test
    public void testEmployeeService() throws Exception{
        PageInfo<Employee> empsPage =  employeeService.getEmpPage(1,10);
        System.out.println(empsPage.getPageNum());//第几页
        System.out.println(empsPage.getPageSize());//每页多少条
        System.out.println(empsPage.getTotal());//总数
        System.out.println(empsPage.getPages());//总共多少页
    }
    @Resource(name = "departmentService")
    private DepartmentService departmentService;
    @org.junit.Test
    public void testDepartmentService() throws Exception{
        System.out.println(departmentService.getDepartmentEmp(1000));
    }


}
