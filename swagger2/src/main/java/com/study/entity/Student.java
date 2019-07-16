package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/9
 * Time: 16:59
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    // 自增 id
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

}
