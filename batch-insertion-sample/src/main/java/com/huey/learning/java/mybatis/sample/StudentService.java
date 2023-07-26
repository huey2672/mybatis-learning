package com.huey.learning.java.mybatis.sample;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class StudentService {

    private static final int BATCH_SIZE = 1000;

    private StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    void batchSaveStudents(List<Student> studentList) {

        Instant start = Instant.now();

        for (int i = 0; i < studentList.size(); i += BATCH_SIZE) {

            List<Student> subList = studentList.subList(i, Math.min(i + BATCH_SIZE, studentList.size()));

            System.out.println("[" + i + ", " + Math.min(i + BATCH_SIZE, studentList.size()) + "]");

            studentMapper.batchSaveStudents(subList);
        }

        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("timeElapsed = " + timeElapsed);

    }

}
