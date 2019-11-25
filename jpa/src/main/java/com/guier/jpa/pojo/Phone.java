package com.guier.jpa.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@NoArgsConstructor
// @Data
@Setter
@Getter
@Accessors(chain = true)
public class Phone {
    @Id
    @GeneratedValue
    private Long id;
    private String pName;
    @OneToOne(mappedBy = "phone",cascade = CascadeType.ALL)
    private Student student;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                '}';
    }
}
