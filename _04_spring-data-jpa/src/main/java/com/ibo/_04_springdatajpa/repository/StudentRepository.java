package com.ibo._04_springdatajpa.repository;

import com.ibo._04_springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(@Param("emailId") String emailId);

}
