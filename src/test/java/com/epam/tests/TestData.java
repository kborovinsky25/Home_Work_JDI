package com.epam.tests;

import au.com.bytecode.opencsv.CSVReader;
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
        return new Object[][] {{"", "1234"},{"epam", ""}};
    }
    @DataProvider
    public static Object[][] dataFromCSV() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src\\test\\resources\\TestData.csv"));
        Object[][] data = reader.readAll().toArray(new Object[0][]);
        return data;
    }
}
