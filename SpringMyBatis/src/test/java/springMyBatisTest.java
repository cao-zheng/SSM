import com.cz.model.Employee;
import com.cz.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Data
public class springMyBatisTest {
    @Resource(name="employeeService")
    private EmployeeService employeeService;

    @Test
    public void applicationTest(){
        Employee employee = employeeService.getEmpByIdLazyLoad(45);
        System.out.println(employee);
    }
    @Test
    public void applicationPageTest(){
        PageInfo<Employee> employeePageInfo = employeeService.getEmpPage(1,10);
        System.out.println("员工总数："+employeePageInfo.getTotal());
        System.out.println("当前页：" + employeePageInfo.getPageNum());
        System.out.println("一页多少数：" + employeePageInfo.getPageSize());
        System.out.println("总页数：" + employeePageInfo.getPages());
        System.out.println("最后一行：" + employeePageInfo.getEndRow());

        for(Employee employee : employeePageInfo.getList()){
            System.out.println(employee);
        }
    }
}
