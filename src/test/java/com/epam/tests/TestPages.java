package com.epam.tests;

import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.entity.Users.DEFAULT;
import static com.epam.tests_logic.enums.States.LOGGED_OUT;
import static com.epam.tests_logic.enums.States.LOG_IN_OUT_IS_OPENED;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.web.matcher.testng.Assert.assertEquals;
import static com.epam.web.matcher.testng.Assert.assertTrue;

public class TestPages extends InitTests{

    @Test
    public void checkHomePage(){
        logger.info("Start validation of home page");
        isInState(LOGGED_OUT);
        assertTrue(homePage.profileBtn.isDisplayed(), "There isn't button Profile");
        assertEquals(homePage.profileBtn.getText(), "", "Profile contains an extra text");
        homePage.logIn();
        assertTrue(homePage.profileName.isDisplayed(), "There isn't button Profile with Name");
        assertEquals(homePage.profileName.getText(), DEFAULT.fullName, "Profile contains an incorrect text");
    }

    @Test
    public void checkLoginForm() {
        logger.info("Start validation of login page");
        isInState(LOGGED_OUT);
        isInState(LOG_IN_OUT_IS_OPENED);
        assertTrue(homePage.loginOnHomePage.name.isDisplayed(), "There isn't textbox for login");
        assertTrue(homePage.loginOnHomePage.loginLbl.isDisplayed(), "There isn't label 'Login'");
        assertTrue(homePage.loginOnHomePage.psw.isDisplayed(), "There isn't textbox for password");
        assertTrue(homePage.loginOnHomePage.pswLbl.isDisplayed(), "There isn't label 'Password'");
        assertTrue(homePage.loginOnHomePage.submit.isDisplayed(), "There isn't button 'Enter'");
        assertEquals(homePage.loginOnHomePage.loginLbl.getText(), "Login", "Login label has text 'Login'");
        assertEquals(homePage.loginOnHomePage.pswLbl.getText(), "Password", "Password label has text 'Password'");
        assertEquals(homePage.loginOnHomePage.submit.getText(), "ENTER", "Enter button has text 'Enter'");
    }
}
