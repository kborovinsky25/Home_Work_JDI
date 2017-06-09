package com.epam.tests;

import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ITable;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.Column.inColumn;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.SIMPLE_TABLE_PAGE;
import static com.epam.tests_logic.ui.TestSite.simpleTablePage;
import static com.epam.web.matcher.testng.Assert.*;

public class TestSimpleTable extends InitTests{

    private ITable table(){
        return simpleTablePage.simpleTable;
    }
    @BeforeMethod
    public void setUpMethod(){
        logger.info("Open page and check it");
        isInState(SIMPLE_TABLE_PAGE);
    }
    @Test(dataProvider = "contentSimpleTable", dataProviderClass = TestData.class)
    public void testContentSimpleTable(String content) {
        logger.info("Check that the table is visible and its contents are correct");
        isTrue(table().isDisplayed(), "table isn't visible");
        isFalse(table().isEmpty(), "table don't have content");
        areEquals(table().columns().count(), "3", "table has incorrect count of columns");
        areEquals(table().rows().count(), "6", "table has incorrect count of rows");
        areEquals(table().getValue(), content, "table has incorrect content");
    }
    @Test
    public void testSearchAndSelect(){
        logger.info("Check that the table is visible and its contents are correct");
        table().rowContains("XML", inColumn(2)).get(2).value.select();
        System.out.println(table().cell(2, 4).getText());
    }
}