package com.co.poli.momentovalorativo.model;

import java.util.Date;

public class Courses {
    private int id;
    private String name_course;
    private String teacher;
    private String description;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private Date deteledAt;

    public Courses(int id, String name_course, String teacher, String description, String password, Date createdAt, Date updatedAt, Date deteledAt) {
        this.id = id;
        this.name_course = name_course;
        this.teacher = teacher;
        this.description = description;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deteledAt = deteledAt;
    }

    public Courses(int id, String name_course, String teacher, String description) {
        this.id = id;
        this.name_course = name_course;
        this.teacher = teacher;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_course() {
        return name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
