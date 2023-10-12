package com.ibo._04_springdatajpa.repository;

import com.ibo._04_springdatajpa.entity.Course;
import com.ibo._04_springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseLA = Course.builder()
                .title("LA")
                .credit(9)
                .build();

        Course courseAna = Course.builder()
                .title("Ana")
                .credit(9)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Björn")
                .lastName("Aye")
                //.courses(List.of(courseLA, courseAna))
                .build();

        teacherRepository.save(teacher);
    }

}
