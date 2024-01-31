package com.springdata.Springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdata.Springdatajpa.entity.Guardian;
import com.springdata.Springdatajpa.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .emailId("johndoe@gmail.com")
                // .guardianEmail("mrjohn@gmail.com")
                // .guardianName("Mr. John")
                // .guardianMobile("9999999999")
                .build();
        Student savedStudent = studentRepository.save(student);
        System.out.println(savedStudent);
    }
    
    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Mr. John")
                .email("mrjohn1@gmail.com")
                .mobile("9999999999")
                .build();
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .emailId("johndoe1@gmail.com")
                .guardian(guardian)
                .build();
       studentRepository.save(student);
    }

    @Test
    public void listAllStudents() {
        List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }

    @Test
    public void pprintStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("John");
        System.out.println(students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("johndoe@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("johndoe@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("johndoe@gmail.com");
        System.out.println(student);
    }

}
