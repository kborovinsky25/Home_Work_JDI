package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;

public class DatePage extends WebPage{
    @JFindBy(id = "datepicker")
    public DatePicker date;

}
