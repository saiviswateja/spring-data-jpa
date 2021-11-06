package com.viswateja.springdatajpa.repository;

import com.viswateja.springdatajpa.entity.Course;
import com.viswateja.springdatajpa.entity.Student;
import com.viswateja.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Course course = Course.builder()
                .title("Python")
                .teacher(Teacher.builder().firstName("kusuma").lastName("teja").build()).build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRequests =
                PageRequest.of(1, 2);
        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("Total Pages = " + totalPages);
        System.out.println("Total Elements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(
            0,
                2,
                Sort.by("credit").descending()
        );
        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title").descending().and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);

    }

    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords);
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com").build();
        course.addStudents(student);

        courseRepository.save(course);
    }
}