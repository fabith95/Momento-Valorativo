package com.co.poli.momentovalorativo.model;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private Date deteledAt;

    public Student(int id, String name, String lastName, int age, String password, Date createdAt, Date updatedAt, Date deteledAt) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deteledAt = deteledAt;
    }

    public Student(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeteledAt() {
        return deteledAt;
    }

    public void setDeteledAt(Date deteledAt) {
        this.deteledAt = deteledAt;
    }
}

