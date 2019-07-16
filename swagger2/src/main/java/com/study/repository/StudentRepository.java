package com.study.repository;

import com.study.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/9
 * Time: 17:03
 */
public interface StudentRepository extends JpaRepository<Student, Integer>, CrudRepository<Student, Integer> {
}
