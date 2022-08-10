package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
public class User {
    private Integer uid;
    private String username;
    private String password;

}
