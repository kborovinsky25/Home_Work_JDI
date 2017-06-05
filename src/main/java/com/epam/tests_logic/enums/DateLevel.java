package com.epam.tests_logic.enums;

/**
 * Created by Kirill_Borovinskii on 05.06.2017.
 */
public enum DateLevel {
    DAY("1"),
    MONTH("Jan"),
    YEAR("-");

    public String value;
    DateLevel(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
