package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.tests_logic.annotations.MDatePicker;
import com.epam.tests_logic.elements.MyDatePicker;
import com.epam.tests_logic.elements.NewDatePicker;
import org.openqa.selenium.support.FindBy;

import static com.epam.tests_logic.ui.TestSite.datesPage;

public class DatePage extends WebPage{

    @MDatePicker(
        textField = @FindBy(id = "datepicker"),
        prev = @FindBy(css = ".datepicker-days .prev"),
        next = @FindBy(css = ".datepicker-days .next")
    )
    public MyDatePicker date;

    @JFindBy(xpath = "//*[@id='datepicker']/input")
    public NewDatePicker datePicker;


    public boolean isOpen() {
        return datesPage.verifyOpened();
    }

}
