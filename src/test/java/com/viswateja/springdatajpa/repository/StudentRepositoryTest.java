package com.viswateja.springdatajpa.repository;

import com.viswateja.springdatajpa.entity.Guardian;
import com.viswateja.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("sai@gmail.com")
                .firstName("teja")
                .lastName("sai")
//                .guardianName("prasad")
//                .guardianEmail("satya@gmail.com")
//                .guardianMobile("57967")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianDetails() {
        Student student = Student.builder()
                .emailId("viswa@gmail.com")
                .firstName("viswa")
                .lastName("sree")
                .guardian(Guardian.builder().email("saritha").mobile("75686").email("saritha@gmail.com").build())
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("viswa");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentLikeGivenName() {
        List<Student> students = studentRepository.findByFirstNameContaining("vis");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("prasad ");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("sai@gmail.com");
        System.out.println("Student is " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("sai@gmail.com");
        System.out.println("Student is " + studentName);
    }

    @Test
    public void printStudentFirstNameByEmailAddressNative() {
        String studentName = studentRepository.getStudentByEmailAddressNative("sai@gmail.com");
        System.out.println("Student is " + studentName);
    }

    @Test
    public void printStudentFirstNameByEmailAddressNativeNamedParam() {
        String studentName = studentRepository.getStudentByEmailAddressNative("sai@gmail.com");
        System.out.println("Student is " + studentName);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("Sree Rama", "sai@gmail.com");
    }
}