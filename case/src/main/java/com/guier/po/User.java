package com.guier.po;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@Accessors(prefix = "f")
@Data
@Builder
public class User {
    private int fAge;
    private String name;
    private int sex;
    private Date birthday;
}
