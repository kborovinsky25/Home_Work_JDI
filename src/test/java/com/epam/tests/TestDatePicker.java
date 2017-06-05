package com.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.DATES_PAGE;
import static com.epam.tests_logic.ui.TestSite.datesPage;
import static com.epam.web.matcher.testng.ScreenAssert.assertEquals;

public class TestDatePicker extends InitTests{
    @BeforeMethod
    public void setUpMethod(){
        isInState(DATES_PAGE);
        logger.info("Open page Dates page");
    }

    @Test
    public void test_1() throws InterruptedException {
        datesPage.datePicker.open();
        Thread.sleep(2000);
        datesPage.datePicker.clickPrev();
        Thread.sleep(3000);
        datesPage.datePicker.setDate("12");
        Thread.sleep(3000);
        assertEquals(datesPage.datePicker.getText(), "05/12/2017");
//        datesPage.datePicker.clear();
//        datesPage.datePicker.newInput("07/15/2016");
//        assertEquals(datesPage.datePicker.getText(), "05/12/2017");
        System.out.println(datesPage.datePicker.getDate());
    }
}
