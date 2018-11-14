import com.cz.mapper.DepartmentMapper;
import com.cz.mapper.EmployeeMapper;
import com.cz.model.Department;
import com.cz.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
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
        DepartmentMapper departmentMapper =  sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.getDepartmentById(1000);
        System.out.println(department);
    }
    @org.junit.Test
    public void testGetEmpByIdLazyLoad() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper =  sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmpByIdLazyLoad(1);
        System.out.println(employee);
        sqlSession.close();
    }
    @org.junit.Test
    public void testGetEmpsByDeptIdLazyLoad(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.getEmpsByDeptIdLazyLoad(1000);
        for (Employee employee:employees) {
            System.out.println(employee);
        }
    }
    @org.junit.Test
    public void testGetDeptById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper =  sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.getDeptById(1000);
        System.out.println(department);
    }
    @org.junit.Test
    public void testfirstCache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper =  sqlSession.getMapper(DepartmentMapper.class);
        Department dept1 = departmentMapper.getDeptById(1002);
        System.out.println(dept1);

        Department dept2 = departmentMapper.getDeptById(1002);
        Department dept3 = departmentMapper.getDeptById(1002);
        //发送多条一样的sql，只查询一遍。如果发送一条sql，commit，缓存清空，下面同样的sql，在次发送
        System.out.println(dept2);
        System.out.println(dept3);
        sqlSession.close();
    }
    @org.junit.Test
    public void testSecondCache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper departmentMapper =  sqlSession.getMapper(DepartmentMapper.class);
        Department dept1 = departmentMapper.getDeptById(1002);
        System.out.println(dept1);
        sqlSession.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        /*二级缓存的mapper级别*/
        DepartmentMapper departmentMapper1 =  sqlSession2.getMapper(DepartmentMapper.class);
        Department dept2 = departmentMapper1.getDeptById(1002);
        Department dept3 = departmentMapper1.getDeptById(1002);
        //发送多条一样的sql，只查询一遍。如果发送一条sql，commit，缓存清空，下面同样的sql，在次发送
        System.out.println(dept2);
        System.out.println(dept3);
        sqlSession.close();

    }
}
