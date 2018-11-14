package com.cz2.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private Date createTime;
}
