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
public class Grade {
    @Id
    @GeneratedValue
    private Long id;
    private String gName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grade",fetch = FetchType.EAGER)
    // @ToString.Exclude
    private Set<Student> students = new HashSet<>();

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gName='" + gName + '\'' +
                '}';
    }
}
