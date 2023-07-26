package com.huey.learning.java.mybatis.sample;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BatchInsertionSample {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        for (long i = 0; i < 100000; i++) {
            Student student = new Student();
            student.setStudId(i);
            student.setStudName("张三" + i);
            student.setSex("M");
            studentList.add(student);
        }

        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            try (SqlSession session = sessionFactory.openSession()) {
                StudentMapper studentMapper = session.getMapper(StudentMapper.class);
                StudentService studentService = new StudentService(studentMapper);
                studentService.batchSaveStudents(studentList);
            }

        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
