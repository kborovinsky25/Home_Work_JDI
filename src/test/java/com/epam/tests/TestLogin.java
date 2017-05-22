package com.epam.tests;

import org.testng.annotations.*;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.tests_logic.ui.TestSite.loginPage;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.*;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;


public class TestLogin extends InitTests{
    @BeforeMethod
    public void before(){
        homePage.shouldBeOpened();
        logger.info("Open page and check it");
    }

    @Test
    public void checkHomePage(){
        logger.info("Start validation of home page");
        assertTrue(homePage.profileDDBtn.isDisplayed(), "There isn't button Profile");
        assertEquals(homePage.profileBtn.getText(), "");
        homePage.openLoginPage();
        loginPage.credentialsInput("epam", "1234");
        loginPage.submit.click();
        assertTrue(homePage.profileDDBtn.isDisplayed(), "There isn't button Profile");
        assertEquals(homePage.profileBtn.getText(), "PITER CHAILOVSKII");
    }

    @Test
    public void checkLoginPage() {
        logger.info("Start validation of login page");
        homePage.openLoginPage();
        assertTrue(loginPage.loginInp.isDisplayed());
        assertTrue(loginPage.loginLbl.isDisplayed());
        assertTrue(loginPage.pswInp.isDisplayed());
        assertTrue(loginPage.pswLbl.isDisplayed());
        assertTrue(loginPage.submit.isDisplayed());
        assertEquals(loginPage.loginLbl.getText(), "Login");
        assertEquals(loginPage.pswLbl.getText(), "Password");
        assertEquals(loginPage.submit.getText(), "ENTER");
    }

    @Test(dataProvider = "correctData", dataProviderClass = TestData.class)
    public void testPosClick(String login, String psw, String userName) {
        logger.info("Positive check with Click");
        homePage.openLoginPage();
        loginPage.credentialsInput(login, psw);
        loginPage.submit.click();
        assertEquals(homePage.profileBtn.getText(), userName, "Incorrect user name");
        assertTrue(homePage.logoutBtn.isDisplayed(), "There isn't Logout button");
    }

    @Test(dataProvider = "correctData", dataProviderClass = TestData.class)
    public void testPosEnter(String login, String psw, String userName) {
        logger.info("Positive check with Enter");
        homePage.openLoginPage();
        loginPage.credentialsInput(login, psw);
        loginPage.pswInp.sendKeys(ENTER);
        assertEquals(homePage.profileBtn.getText(), userName, "Incorrect user name");
        assertTrue(homePage.logoutBtn.isDisplayed(), "There isn't Logout button");
    }

    @Test(dataProvider = "dataFromCSV", dataProviderClass = TestData.class)
    public void testNegCsv(String login, String psw) {
        logger.info("Negative check with data from csv file");
        homePage.openLoginPage();
        loginPage.credentialsInput(login, psw);
        loginPage.submit.click();
        assertTrue(loginPage.errorLbl.isDisplayed(), "There isn't error message");
        assertEquals(loginPage.errorLbl.getText(), "* Login Faild", "Incorrect error message");
    }

    @Test(dataProvider = "incorrectData", dataProviderClass = TestData.class)
    public void testIncompleteData(String login, String psw) {
        logger.info("Login test for incomplete data");
        homePage.openLoginPage();
        loginPage.credentialsInput(login, psw);
        loginPage.submit.click();
        assertTrue(loginPage.errorLbl.isDisplayed(), "There isn't error message");
        assertEquals(loginPage.errorLbl.getText(), "* Login Faild", "Incorrect error message");
    }

//    @AfterMethod
//    public void after(){
//        homePage.clearCache();
//        homePage.refresh();
//    }
}
