import com.cz.dao.EmpDto;
import com.cz.mapper.AdminMapper;
import com.cz.mapper.DepartmentMapper;
import com.cz.mapper.EmployeeMapper;
import com.cz.model.Admin;
import com.cz.model.Department;
import com.cz.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String config= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @org.junit.Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeDao = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        EmpDto empDto = new EmpDto();
        employee.setEmpName("吴");
        employee.setGender("男");
        empDto.setEmployee(employee);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1000);
        ids.add(1001);
        ids.add(1002);
        empDto.setIds(ids);
        List<Employee> emps = employeeDao.getEmpByEmpDto(empDto);
        for (Employee emp:emps) {
            System.out.println(emp);
        }
        sqlSession.close();
    }
    @org.junit.Test
    public void testSelectKey(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = new Admin();
        admin.setName("潭州学院");
        admin.setDeptName("曹冲");
        int key = adminMapper.addAdmin(admin);
        System.out.println(key);
        System.out.println(admin.getDeptId());
        sqlSession.close();
    }
    @org.junit.Test
    public void testGetAdminAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> admins = adminMapper.getAdminAll();
        for (Admin admin:admins) {
            System.out.println(admin);
        }
    }
    @org.junit.Test
    public void testGetDepartmentTypeTwo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> depts =  departmentMapper.getDepartmentTypeTwo();
        for (Department department:depts) {
            System.out.println(department);
        }
        sqlSession.close();
    }
    @org.junit.Test
    public void testGetDepartmentEmp(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> depts =  departmentMapper.getDepartmentEmp(1002);
        for (Department department:depts) {
            System.out.println(department);
        }
        sqlSession.close();
    }
    @org.junit.Test
    public void testGetDepartmentEmpAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> depts =  departmentMapper.getDepartmentEmpAll(1002);
        for (Department department:depts) {
            System.out.println(department);
        }
        sqlSession.close();
    }
}
