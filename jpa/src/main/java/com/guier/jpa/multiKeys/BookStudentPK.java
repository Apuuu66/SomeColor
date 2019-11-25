package com.guier.jpa.multiKeys;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookStudentPK implements Serializable {
    Long id;
    Long sId;
}
