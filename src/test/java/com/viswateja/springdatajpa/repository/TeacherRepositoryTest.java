package com.viswateja.springdatajpa.repository;

import com.viswateja.springdatajpa.entity.Course;
import com.viswateja.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    public TeacherRepository teacherRepository;

    @Test
    public void saveTeacherTest() {

        Course courseDBA = Course.builder().title("DBA").credit(2).build();
        Course courseJava = Course.builder().title("Java").credit(3).build();

        Teacher teacher = teacherRepository.save(Teacher.builder()
                            .firstName("Qutub")
                            .lastName("pshyco")
//                            .courses(Arrays.asList(courseDBA, courseJava))
                            .build());

        teacherRepository.save(teacher);

    }
}