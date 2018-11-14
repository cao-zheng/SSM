import com.cz.mapper.StudentDao;
import com.cz.mapper.com.cz.dao.impl.StudentDaoImpl;
import com.cz.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String configFile = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(configFile);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @org.junit.Test
    public void testGetStudentById(){
        StudentDao stuDao = new StudentDaoImpl(sqlSessionFactory);
        System.out.println(stuDao.getStudentById(1));
    }
    @org.junit.Test
    public void testGetStudentList(){
        StudentDao stuDao = new StudentDaoImpl(sqlSessionFactory);
        List<Student> studentList =stuDao.getStudentList();
        for (Student student:studentList) {
            System.out.println(student);
        }
    }
    @org.junit.Test
    public void testAddStudent() {
        StudentDao studentDao = new StudentDaoImpl(sqlSessionFactory);
        Student student = new Student();
        student.setName("程序添加2");
        student.setAge(3);
        student.setCreateTime(new Date());
        studentDao.addStudent(student);
    }
    @org.junit.Test
    public void delStudent(){
        StudentDao studentDao = new StudentDaoImpl(sqlSessionFactory);
        studentDao.delStudent(4);
    }
    @org.junit.Test
    public void updateStudent(){
        StudentDao studentDao = new StudentDaoImpl(sqlSessionFactory);
        Student student = new Student();
        student.setAge(88);
        student.setName("updateNow");
        student.setCreateTime(new Date());

        student.setId(2);
        studentDao.updateStudent(student);
    }
    public static void main(String[] args) {
        String configFile = "mybatis-config.xml";
        try {
            //1.读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(configFile);
            //2.通过SqlSessionFactoryBuilder创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //3.通过sqlSessionFactory创建SqlSession
            SqlSession session = sqlSessionFactory.openSession();
            //4.调用sqlSession接口方法来执行数据库操作
            Student stu =session.selectOne("getStudentById",1);
            //5.测试
            System.out.println(stu);
            //6.关闭sqlSession
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
