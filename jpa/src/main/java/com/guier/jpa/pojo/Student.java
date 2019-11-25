package com.guier.jpa.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
// @Data
@Setter
@Getter
@Accessors(chain = true)
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String sName;

    @OneToOne
    @JoinColumn(name = "phone")
    private Phone phone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grade")
    // @ToString.Exclude
    private Grade grade;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinTable(name = "student_teacher", inverseJoinColumns = @JoinColumn(name = "teacher_id"), joinColumns = @JoinColumn(name = "student_id"))
    // @JoinTable(name = "tt",joinColumns = @JoinColumn(name = "c_id"),inverseJoinColumns = @JoinColumn(name = "s_id"))
    // @ToString.Exclude
    private Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sName='" + sName + '\'' +
                '}';
    }
}
