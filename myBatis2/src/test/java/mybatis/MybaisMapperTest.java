package mybatis;

import com.cz2.mapper.UserMapper;
import com.cz2.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybaisMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String configFile = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(configFile);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUserById(1));
        sqlSession.close();
    }
    @Test
    public void testGetUserList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUserList());
        sqlSession.close();
    }
    @Test
    public void testAddUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setPassword("xxx231231");
        user.setName("insert now");
        user.setCreateTime(new Date());
        user.setAge(1);
        userMapper.addUser(user);
        sqlSession.close();
    }
    @Test
    public void testDelStudent(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delUser(2);
        sqlSession.close();
    }
    @Test
    public void testUpdateStudent(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setPassword("xxxaaa");
        user.setName("insert now2");
        user.setCreateTime(new Date());
        user.setAge(1);
        user.setId(3);
        userMapper.updateUser(user);
        sqlSession.close();
    }
    @Test
    public void testGetUserByNameAndPassword(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("insert now");
        user.setPassword("xxx231231");
        List<User> userList= userMapper.getUserByNameAndPassword(user);
        System.out.println(userList);
    }
}
