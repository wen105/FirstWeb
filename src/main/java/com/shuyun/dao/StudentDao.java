package com.shuyun.dao;

import com.shuyun.entity.Student;

import java.util.List;

/**
 * Created by shuyun on 2016/8/2.
 * 学生表处理的接口类
 */
public interface StudentDao {
    int addStudent(Student student);

    int deleteStudent(int stuId);

    List<Student> findAllStudent();

    int updateStudent(Student student);
}
