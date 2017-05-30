package com.epam.tests;

import com.epam.tests_logic.entity.User;
import org.testng.annotations.*;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.*;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;


public class TestLogin extends InitTests{
    @BeforeMethod
    public void before(){
        homePage.shouldBeOpened();
        logger.info("Open page and check it");
    }

    @Test(dataProvider = "userEntity", dataProviderClass = TestData.class)
    public void checkHomePage(User user){
        logger.info("Start validation of home page");
        assertTrue(homePage.profileDDBtn.isDisplayed(), "There isn't button Profile");
        assertEquals(homePage.profileBtn.getText(), "");
        homePage.openLoginPage();
        homePage.loginOnHomePage.submit(user);
        assertTrue(homePage.profileDDBtn.isDisplayed(), "There isn't button Profile");
        assertEquals(homePage.profileBtn.getText(), user.fullName);
    }

    @Test
    public void checkLoginPage() {
        logger.info("Start validation of login page");
        homePage.openLoginPage();
        assertTrue(homePage.loginOnHomePage.name.isDisplayed());
        assertTrue(homePage.loginOnHomePage.loginLbl.isDisplayed());
        assertTrue(homePage.loginOnHomePage.psw.isDisplayed());
        assertTrue(homePage.loginOnHomePage.pswLbl.isDisplayed());
        assertTrue(homePage.loginOnHomePage.submit.isDisplayed());
        assertEquals(homePage.loginOnHomePage.loginLbl.getText(), "Login");
        assertEquals(homePage.loginOnHomePage.pswLbl.getText(), "Password");
        assertEquals(homePage.loginOnHomePage.submit.getText(), "ENTER");
    }

    @Test(dataProvider = "userEntity", dataProviderClass = TestData.class)
    public void testPosClick(User user) {
        logger.info("Positive check with Click");
        homePage.openLoginPage();
        homePage.loginOnHomePage.submit(user);
        assertEquals(homePage.profileBtn.getText(), user.fullName, "Incorrect user name");
        assertTrue(homePage.logoutBtn.isDisplayed(), "There isn't Logout button");
    }

    @Test(dataProvider = "userEntity", dataProviderClass = TestData.class)
    public void testPosEnter(User user) {
        logger.info("Positive check with Enter");
        homePage.openLoginPage();
        homePage.loginOnHomePage.fill(user);
        homePage.loginOnHomePage.psw.sendKeys(ENTER);
        assertEquals(homePage.profileBtn.getText(), user.fullName, "Incorrect user name");
        assertTrue(homePage.logoutBtn.isDisplayed(), "There isn't Logout button");
    }

    @Test(dataProvider = "dataFromCSV", dataProviderClass = TestData.class)
    public void testNegCsv(String login, String psw) {
//    public void testNegCsv(User user) {
        logger.info("Negative check with data from csv file");
        homePage.openLoginPage();
        homePage.loginOnHomePage.credentialsInput(login, psw);
        homePage.loginOnHomePage.submit.click();
//        homePage.loginOnHomePage.submit(user);
        assertTrue(homePage.loginOnHomePage.errorLbl.isDisplayed(), "There isn't error message");
        assertEquals(homePage.loginOnHomePage.errorLbl.getText(), "* Login Faild", "Incorrect error message");
    }

    @Test(dataProvider = "incorrectData", dataProviderClass = TestData.class)
    public void testIncompleteData(User user) {
        logger.info("Login resultsForm for incomplete data");
        homePage.openLoginPage();
        homePage.loginOnHomePage.submit(user);
        assertTrue(homePage.loginOnHomePage.errorLbl.isDisplayed(), "There isn't error message");
        assertEquals(homePage.loginOnHomePage.errorLbl.getText(), "* Login Faild", "Incorrect error message");
    }


//    @AfterMethod
//    public void after(){
//        homePage.clearCache();
//        homePage.refresh();
//    }
}
