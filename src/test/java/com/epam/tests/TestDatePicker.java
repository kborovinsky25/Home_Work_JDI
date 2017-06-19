package com.epam.tests;

import com.epam.tests_logic.elements.NewDatePicker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.DATES_PAGE;
import static com.epam.tests_logic.ui.TestSite.datesPage;
import static com.epam.web.matcher.testng.Assert.*;

@Title("Check page with Date Picker")
public class TestDatePicker extends InitTests{
    private NewDatePicker date(){
        return datesPage.datePicker;
    }

    @BeforeMethod
    public void setUpMethod(){
        isInState(DATES_PAGE);
        logger.info("Open page Dates page");
    }
    @Test
    public void checkPrevNext(){
        logger.info("Check the work of the DatePicker buttons");
        date().open();
        String openTitle = date().getTitle();
        date().clickPrev();
        isFalse(openTitle.equals(date().getTitle()), "button Prev isn't work");
        date().clickNext();
        isTrue(openTitle.equals(date().getTitle()), "button Next isn't work");
    }
    @Test(dataProvider = "correctDate", dataProviderClass = TestData.class)
    public void checkDirectInput_CorrectDate(String date){
        logger.info("Check the work of the DatePicker input text field with correct date");
        date().newInput(date);
        areEquals(date().getText(), date, "the text field has a value other than the value entered");
    }
    @Test(dataProvider = "incorrectDate", dataProviderClass = TestData.class)
    public void checkDirectInput_IncorrectDate(String date){
        logger.info("Check the work of the DatePicker input text field with incorrect date");
        date().newInput(date);
        areDifferent(date().getText(), date, "the text field has entered incorrect value");
    }
    @Test(dataProvider = "correctDate", dataProviderClass = TestData.class)
    public void checkSetDate_CorrectDate(String date){
        logger.info("Check the work of the DatePicker with set correct date");
        date().setDate(date);
        areEquals(date().getText(), date, "the text field has a value other than the value entered");
    }
}
