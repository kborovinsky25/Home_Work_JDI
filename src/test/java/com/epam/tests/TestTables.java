package com.epam.tests;

import com.epam.tests_logic.entity.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.tests_logic.ui.TestSite.loginOnHomePage;
import static com.epam.tests_logic.ui.TestSite.simpleTablePage;

public class TestTables extends InitTests{
    @BeforeMethod
    public void setUpMethod(){
        homePage.shouldBeOpened();
        logger.info("Open page and check it");

    }
    @Test(dataProvider = "userEntity", dataProviderClass = TestData.class)
    public void test_1(User user) throws InterruptedException {
        homePage.openLoginPage();
        loginOnHomePage.submit(user);
//        homePage.treeMenu.hoverAndClick("SERVICE|DATES");
//        homePage.treeMenu.clickOn("SERVICE");
        homePage.menuDblClick("Service", "Simple Table");
//        Thread.sleep(2000);
        System.out.println(simpleTablePage.sTable.cell(1, 1).getText());
        System.out.println(simpleTablePage.sTable.headers());
        System.out.println(simpleTablePage.sTable.columns().count());
        System.out.println(simpleTablePage.sTable.rows().count());
    }
}
