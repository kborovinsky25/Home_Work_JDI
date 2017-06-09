package com.epam.tests;

import com.epam.tests_logic.entity.User;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.entity.Users.DEFAULT;
import static com.epam.tests_logic.enums.States.LOGGED_IN;
import static com.epam.tests_logic.enums.States.LOGGED_OUT;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.web.matcher.testng.Assert.*;


public class TestLogin extends InitTests{

    @Test
    public void testLoginPositive(){
        logger.info("Positive check");
        isInState(LOGGED_OUT);
        homePage.logIn();
        areEquals(homePage.profileBtn.getText(), DEFAULT.fullName, "Incorrect user name");
        isTrue(homePage.isLoggedIn(), "There isn't Logout button");
    }
    @Test(dataProvider = "wrongOrIncompleteLogData", dataProviderClass = TestData.class)
    public void testLoginNegativeWrong(User user){
        logger.info("Negative check with data from dataProvider");
        isInState(LOGGED_OUT);
        homePage.logIn(user);
        isTrue(homePage.isErrorLogin(), "There isn't error message");
        areEquals(homePage.loginOnHomePage.errorLbl.getText(), "* Login Faild", "Incorrect error message");
    }
    @Test
    public void testLogout(){
        logger.info("Check logout");
        isInState(LOGGED_IN);
        homePage.logOut();
        areEquals(homePage.profileBtn.getText(), "", "Profile contains an extra text");
        isFalse(homePage.isLoggedIn(), "Logout is failed");
    }

//    @Test(dataProvider = "userEntity", dataProviderClass = TestData.class)
//    public void testPosEnter(User user) {
//        logger.info("Positive check with Enter");
//        homePage.openLoginPage();
//        homePage.loginOnHomePage.fill(user);
//        homePage.loginOnHomePage.psw.sendKeys(ENTER);
//        assertEquals(homePage.profileBtn.getText(), user.fullName, "Incorrect user name");
//        assertTrue(homePage.logoutBtn.isDisplayed(), "There isn't Logout button");
//    }


}
