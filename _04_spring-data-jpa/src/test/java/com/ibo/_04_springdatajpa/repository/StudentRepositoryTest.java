package com.ibo._04_springdatajpa.repository;

import com.ibo._04_springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("ibo@gmail.com")
                .firstName("ibo")
                .lastName("ibooo")
                .guardianName("j from the b")
                .guardianEmail("j@gmail.com")
                .guardianMobile("12345")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

}
