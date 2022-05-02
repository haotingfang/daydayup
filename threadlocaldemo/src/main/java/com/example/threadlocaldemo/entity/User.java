package com.example.threadlocaldemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
}
