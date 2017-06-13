package com.epam.tests_logic.enums;

/**
 * Created by Kirill_Borovinskii on 6/12/2017.
 */
public enum DropList {
    COLUMN1("Column 1"),
    COLUMN2("Column 2"),
    COLUMN3("Column 3");

    public String value;
    DropList(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
