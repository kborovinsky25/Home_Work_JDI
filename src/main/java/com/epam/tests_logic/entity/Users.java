package com.epam.tests_logic.entity;

public class Users {
    public static User DEFAULT = new User();
    public static User EMPTY_PASSWORD = new User("epam", "", "");
    public static User EMPTY_NAME = new User("", "1234", "");
    public static User WRONG_NAME = new User("ipam", "1234", "");
    public static User WRONG_PASSWORD = new User("epam", "klmn1", "");
}
