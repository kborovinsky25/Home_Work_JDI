package com.epam.tests_logic.entity;

public class User {
    public String name = "epam";
    public String lastName = "testLastName";
    public String psw = "1234";
    public String description = "resultsForm description text";
    public String fullName = "PITER CHAILOVSKII";

    public User(){}

    public User(String name, String psw, String lastName, String description, String fullName){
        this.name = name;
        this.psw = psw;
        this.lastName = lastName;
        this.description = description;
        this.fullName = fullName;
    }
    public User(String name, String psw, String fullName){
        this.name = name;
        this.psw = psw;
        this.fullName = fullName;
    }
}
