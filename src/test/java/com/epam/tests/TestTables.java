package com.epam.tests;

import com.epam.tests_logic.entity.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.LOGGED_IN;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.tests_logic.ui.TestSite.simpleTablePage;

public class TestTables extends InitTests{
    @BeforeMethod
    public void setUpMethod(){
        logger.info("Open page and check it");
        isInState(LOGGED_IN);
    }
    @Test
    public void test() throws InterruptedException {
        homePage.treeMenu.clickAndClick("SERVICE|DATES");
        Thread.sleep(3000);
    }
    @Test(dataProvider = "userEntity", dataProviderClass = TestData.class)
    public void test_1(User user) throws InterruptedException {

        System.out.println(simpleTablePage.sTable.cell(1, 1).getText());
        System.out.println(simpleTablePage.sTable.headers());
        System.out.println(simpleTablePage.sTable.columns().count());
        System.out.println(simpleTablePage.sTable.rows().count());
    }
}
