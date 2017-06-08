package com.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.DATES_PAGE;
import static com.epam.tests_logic.ui.TestSite.datesPage;
import static com.epam.web.matcher.testng.Assert.*;

public class TestDatePicker extends InitTests{

    @BeforeMethod
    public void setUpMethod(){
        isInState(DATES_PAGE);
        logger.info("Open page Dates page");
    }

    @Test
    public void checkPrevNext(){
        logger.info("Check the work of the DatePicker buttons");
        datesPage.datePicker.open();
        String openTitle = datesPage.datePicker.getTitle();
        datesPage.datePicker.clickPrev();
        assertFalse(openTitle.equals(datesPage.datePicker.getTitle()), "button Prev isn't work");
        datesPage.datePicker.clickNext();
        assertTrue(openTitle.equals(datesPage.datePicker.getTitle()), "button Next isn't work");
    }

    @Test(dataProvider = "correctDate", dataProviderClass = TestData.class)
    public void checkDirectInput_CorrectDate(String date){
        logger.info("Check the work of the DatePicker input text field with correct date");
        datesPage.datePicker.newInput(date);
        assertEquals(datesPage.datePicker.getText(), date, "the text field has a value other than the value entered");
    }
    @Test(dataProvider = "incorrectDate", dataProviderClass = TestData.class)
    public void checkDirectInput_IncorrectDate(String date){
        logger.info("Check the work of the DatePicker input text field with incorrect date");
        datesPage.datePicker.newInput(date);
        assertNotSame(datesPage.datePicker.getText(), date, "the text field has entered incorrect value");
    }
    @Test(dataProvider = "correctDate", dataProviderClass = TestData.class)
    public void checkSetDate_CorrectDate(String date){
        logger.info("Check the work of the DatePicker with set correct date");
        datesPage.datePicker.setDate(date);
        assertEquals(datesPage.datePicker.getText(), date, "the text field has a value other than the value entered");
    }
}
