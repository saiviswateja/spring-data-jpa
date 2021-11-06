package com.viswateja.springdatajpa.repository;

import com.viswateja.springdatajpa.entity.Course;
import com.viswateja.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.dailycodebuffer.com")
                .course(Course.builder()
                        .title("System Design").
                                credit(10).
                                build())
                .build();
        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourses() {
        List<CourseMaterial> courseMaterialList = repository.findAll();
        System.out.println(courseMaterialList);
    }
}