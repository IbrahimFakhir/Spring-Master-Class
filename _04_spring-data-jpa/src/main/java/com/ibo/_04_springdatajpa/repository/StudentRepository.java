package com.ibo._04_springdatajpa.repository;

import com.ibo._04_springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String firstName);

    @Query("""
        SELECT s
        FROM Student s
        WHERE s.emailId = ?1
    """)
    Student getStudentByEmailAddress(String emailId);

    @Query("""
        SELECT s.firstName
        FROM Student s
        WHERE s.emailId = ?1
    """)
    String getStudentFirstNameByEmailAddress(String emailId);

}
