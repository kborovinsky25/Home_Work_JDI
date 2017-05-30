package com.epam.tests_logic.enums;

public enum HeaderMenu {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    public String value;
    HeaderMenu(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
