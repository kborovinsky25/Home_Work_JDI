package com.epam.tests;

import com.epam.tests_logic.entity.User;
import com.epam.tests_logic.entity.Users;
import org.testng.annotations.DataProvider;

public class TestData {

//    @DataProvider
//    public static Object[][] dataFromCSV() throws IOException {
//        CSVReader reader = new CSVReader(new FileReader("src\\test\\resources\\TestData.csv"));
//        System.out.println(reader.readNext());
//        Object[][] data = reader.readAll().toArray(new Object[0][]);
//        System.out.println(data);
//        return data;
//    }
    @DataProvider
    public static Object[][] userEntity(){
        return new Object[][] {{new User("epam",
                                         "1234",
                                         "testLastName",
                                         "resultsForm description text",
                                         "PITER CHAILOVSKII")}};
    }
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

}
