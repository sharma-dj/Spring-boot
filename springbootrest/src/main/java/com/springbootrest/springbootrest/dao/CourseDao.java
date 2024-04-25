package com.springbootrest.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrest.springbootrest.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
	
}
