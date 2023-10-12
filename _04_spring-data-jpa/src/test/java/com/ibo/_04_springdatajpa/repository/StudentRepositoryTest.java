package com.ibo._04_springdatajpa.repository;

import com.ibo._04_springdatajpa.entity.Guardian;
import com.ibo._04_springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                //.guardianName("j from the b")
                //.guardianEmail("j@gmail.com")
                //.guardianMobile("12345")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("my g")
                .email("g@gmail.com")
                .mobile("13532")
                .build();

        Student student = Student.builder()
                .firstName("christian")
                .lastName("goerdes")
                .emailId("chr@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentsByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("chr");

        System.out.println("students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("ibo@gmail.com");

        System.out.println("student = " + student);
    }

}
