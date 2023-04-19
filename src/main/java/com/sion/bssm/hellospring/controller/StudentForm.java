package com.sion.bssm.hellospring.controller;

public class StudentForm {
    private Long id;
    private String name;
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
