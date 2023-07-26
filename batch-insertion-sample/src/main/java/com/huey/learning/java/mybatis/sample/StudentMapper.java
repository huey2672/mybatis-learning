package com.huey.learning.java.mybatis.sample;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    void batchSaveStudents(@Param("students") List<Student> studentList);

}
