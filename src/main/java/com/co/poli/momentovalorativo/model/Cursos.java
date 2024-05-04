package com.co.poli.momentovalorativo.model;

import java.util.Date;

public class Cursos {
    private int id;
    private String name_curse;
    private String teacher;
    private String description;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private Date deteledAt;

    public Cursos(int id, String name_curse, String teacher, String description, String password, Date createdAt, Date updatedAt, Date deteledAt) {
        this.id = id;
        this.name_curse = name_curse;
        this.teacher = teacher;
        this.description = description;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deteledAt = deteledAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_curse() {
        return name_curse;
    }

    public void setName_curse(String name_curse) {
        this.name_curse = name_curse;
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
