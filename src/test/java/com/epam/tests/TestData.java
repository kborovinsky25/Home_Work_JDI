package com.epam.tests;

import au.com.bytecode.opencsv.CSVReader;
import com.epam.tests_logic.entity.User;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;

public class TestData {

    @DataProvider
    public static Object[][] correctData() {
        return new Object[][] {{"epam", "1234", "PITER CHAILOVSKII"},{"epam", "1234", "PITER CHAILOVSKII"}};
    }
    @DataProvider
    public static Object[][] incorrectData() {
        return new Object[][] {{new User("", "1234")},{new User("epam", "")}};
    }
    @DataProvider
    public static Object[][] dataFromCSV() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src\\resultsForm\\resources\\TestData.csv"));
        System.out.println(reader.readNext());
        Object[][] data = reader.readAll().toArray(new Object[0][]);
        System.out.println(data);
        return data;
    }
    @DataProvider
    public static Object[][] userEntity(){
        return new Object[][] {{new User("epam",
                                         "1234",
                                         "testLastName",
                                         "resultsForm description text",
                                         "PITER CHAILOVSKII")}};
    }
}
