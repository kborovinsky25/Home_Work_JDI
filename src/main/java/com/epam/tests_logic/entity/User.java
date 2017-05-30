package com.epam.tests_logic.entity;

public class User {
    public String name;
    public String lastName;
    public String psw;
    public String description;
    public String fullName;

    public User(String name, String psw, String lastName, String description, String fullName){
        this.name = name;
        this.psw = psw;
        this.lastName = lastName;
        this.description = description;
        this.fullName = fullName;
    }
    public User(String name, String psw){
        this.name = name;
        this.psw = psw;
    }
}
