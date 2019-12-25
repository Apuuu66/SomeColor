package com.guier.jpa.specification.po;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class User {
    @Id
    Integer id;
    String name;
    String mobile;
}
