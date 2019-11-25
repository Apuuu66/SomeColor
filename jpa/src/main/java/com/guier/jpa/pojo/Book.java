package com.guier.jpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @IdClass(BookStudentPK.class)
@IdClass(Book.class)
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long sId;
    private String name;

    public Book(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", sId=" + sId +
                ", name='" + name + '\'' +
                '}';
    }
}
