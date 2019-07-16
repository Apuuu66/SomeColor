package com.study.service;

import com.study.entity.Student;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/9
 * Time: 17:05
 */
public interface StudentService {
    Student save(Student student);

    Student findById(Integer id);

    void delete(Integer id);

    List<Student> findAll();
}
