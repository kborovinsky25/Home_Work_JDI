package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.tests_logic.elements.NewDatePicker;

import static com.epam.tests_logic.ui.TestSite.datesPage;

public class DatePage extends WebPage{

    @JFindBy(xpath = "//*[@id='datepicker']/input")
    public NewDatePicker datePicker;

    public boolean isOpen() {
        return datesPage.verifyOpened();
    }

}
