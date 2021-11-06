package com.viswateja.springdatajpa.repository;

import com.viswateja.springdatajpa.entity.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContaining(String title, Pageable pageRequest);
}
