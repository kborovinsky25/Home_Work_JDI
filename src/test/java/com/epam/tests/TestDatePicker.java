package com.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.DATES_PAGE;
import static com.epam.tests_logic.ui.TestSite.datesPage;
import static com.epam.web.matcher.testng.Assert.assertFalse;
import static com.epam.web.matcher.testng.Assert.assertTrue;
import static com.epam.web.matcher.testng.Assert.assertEquals;

public class TestDatePicker extends InitTests{
    @BeforeMethod
    public void setUpMethod(){
        isInState(DATES_PAGE);
        logger.info("Open page Dates page");
    }

    @Test
    public void checkPrevNext() throws InterruptedException {
        logger.info("Check the work of the DatePicker buttons");
        datesPage.datePicker.open();
        String openTitle = datesPage.datePicker.getTitle();
        datesPage.datePicker.clickPrev();
        assertFalse(openTitle.equals(datesPage.datePicker.getTitle()), "button Prev isn't work");
        datesPage.datePicker.clickNext();
        assertTrue(openTitle.equals(datesPage.datePicker.getTitle()), "button Next isn't work");

        datesPage.datePicker.setDate("12");
        assertEquals(datesPage.datePicker.getText(), "06/12/2017");
//        datesPage.datePicker.clear();
//        datesPage.datePicker.newInput("07/15/2016");
//        assertEquals(datesPage.datePicker.getText(), "05/12/2017");
        System.out.println(datesPage.datePicker.getTitle());
    }
}
