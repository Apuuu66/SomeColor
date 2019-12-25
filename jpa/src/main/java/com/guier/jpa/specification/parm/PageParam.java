package com.guier.jpa.specification.parm;

public class PageParam<T> {
    private Integer pageSize = 10;
    private Integer pageNumber = 1;
    private String searchName;
    private String searchMobile;
    private String searchId;
}
