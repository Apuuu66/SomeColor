package com.guier.jpa.repository;

import com.guier.jpa.pojo.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long>, JpaRepository<Grade, Long> {


}
