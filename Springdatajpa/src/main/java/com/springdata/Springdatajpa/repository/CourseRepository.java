package com.springdata.Springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springdata.Springdatajpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
