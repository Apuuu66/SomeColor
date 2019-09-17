package com.guier.jpa.repository;

import com.guier.jpa.pojo.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
