package com.cz.mapper.com.cz.dao.impl;

import com.cz.mapper.StudentDao;
import com.cz.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void addStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.insert("addStudent",student);
        System.out.println("行数： " + rows);
        sqlSession.close();
    }

    public StudentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Student getStudentById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student stu = sqlSession.selectOne("getStudentById",id);
        sqlSession.close();
        return stu;
    }

    @Override
    public List<Student> getStudentList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Student> studentList = sqlSession.selectList("getStudentList");
        sqlSession.close();
        return studentList;
    }

    @Override
    public void delStudent(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int i = sqlSession.delete("delStudent",id);
        System.out.println("删除 " + i);
        sqlSession.close();
    }

    @Override
    public void updateStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int i = sqlSession.update("updateStudent",student);
        System.out.println("修改" + i);
        sqlSession.close();
    }
}
