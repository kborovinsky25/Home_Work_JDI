package com.epam.tests;

import com.epam.tests_logic.entity.Users;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider
    public static Object[][] wrongOrIncompleteLogData() {
        return new Object[][] {
                { Users.EMPTY_PASSWORD},
                { Users.EMPTY_NAME},
                { Users.WRONG_NAME},
                { Users.WRONG_PASSWORD}
        };
    }
    @DataProvider
    public static Object[][] testContactPage() {
        return new Object[][] {
                { Users.DEFAULT},
                { Users.ADMIN}
        };
    }
    @DataProvider
    public static Object[][] correctDate(){
        return new Object[][]{{"06/15/2017"},
                {"12/28/2117"},
                {"01/01/1956"}};
    }
    @DataProvider
    public static Object[][] incorrectDate(){
        return new Object[][]{{"14/15/1017"},
                {"12/43/2017"},
                {"05/05/-12"}};
    }
    @DataProvider
    public static Object[][] contentSimpleTable(){
        return new Object[][]{{
                "||X||area|type|framework||\n" +
                "||1||Drivers|Selenium Custom|JavaScript, Appium, WinAPI, Sikuli||\n" +
                "||2||Test Runner|TestNG, JUnit Custom|MSTest, NUnit, Epam||\n" +
                "||3||Asserter|TestNG, JUnit, Custom|MSTest, NUnit, Epam||\n" +
                "||4||Logger|Log4J, TestNG log, Custom|Epam, XML/Json logging, Hyper logging||\n" +
                "||5||Reporter|Jenkins, Allure, Custom|EPAM Report portal, Serenity, TimCity, Hudson||\n" +
                "||6||BDD/DSL|Custom|Cucumber, Jbehave, Thucydides, SpecFlow||"}};
    }
    @DataProvider
    public static Object[][] contentComplexTable(){
        return new Object[][]{{
                "||X||1|2|3||\n" +
                "||1||Drivers|Selenium Custom|JavaScript, Appium, WinAPI, Sikuli||\n" +
                "||2||Test Runner|TestNG, JUnit Custom|MSTest, NUnit, Epam||\n" +
                "||3||Asserter|TestNG, JUnit, Custom|MSTest, NUnit, Epam||\n" +
                "||4||Logger|Log4J, TestNG log, Custom|Epam, XML/Json logging, Hyper logging||\n" +
                "||5||Reporter|Jenkins, Allure, Custom|EPAM Report portal, Serenity, TimCity, Hudson||\n" +
                "||6||BDD/DSL|Custom|Cucumber, Jbehave, Thucydides, SpecFlow||"}};
    }
}
