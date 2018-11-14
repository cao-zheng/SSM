package com.cz.mapper;

import com.cz.model.Student;

import java.util.List;

public interface StudentDao {
    public Student getStudentById(int id);
    public List<Student> getStudentList();
    public void delStudent(int id);
    public void updateStudent(Student student);
    public void addStudent(Student student);
}
