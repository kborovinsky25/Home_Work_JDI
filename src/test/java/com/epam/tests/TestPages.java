package com.epam.tests;

import com.epam.tests_logic.ui.forms.LoginOnHomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.Utils.makeScreen;
import static com.epam.tests_logic.entity.Users.DEFAULT;
import static com.epam.tests_logic.enums.States.LOGGED_OUT;
import static com.epam.tests_logic.enums.States.LOG_IN_OUT_IS_OPENED;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.web.matcher.testng.Assert.areEquals;
import static com.epam.web.matcher.testng.Assert.isTrue;

@Title("Check start page and Login form")
public class TestPages extends InitTests{
    public LoginOnHomePage loginForm(){
        return homePage.loginOnHomePage;
    }

    @BeforeMethod
    public void setUpMethod(){
        isInState(LOGGED_OUT);
        logger.info("Open page Home page");
    }
    @Test
    public void checkHomePage(){
        logger.info("Start validation of home page");
        isTrue(homePage.profileBtn.isDisplayed(), "There isn't button Profile");
        areEquals(homePage.profileBtn.getText(), "", "Profile contains an extra text");
        homePage.logIn();
        isTrue(homePage.profileName.isDisplayed(), "There isn't button Profile with Name");
        areEquals(homePage.profileName.getText(), DEFAULT.fullName, "Profile contains an incorrect text");
        makeScreen();
    }
    @Test
    public void checkLoginForm() {
        logger.info("Start validation of login page");
        isInState(LOG_IN_OUT_IS_OPENED);
        isTrue(loginForm().name.isDisplayed(), "There isn't textbox for login");
        isTrue(loginForm().loginLbl.isDisplayed(), "There isn't label 'Login'");
        isTrue(loginForm().psw.isDisplayed(), "There isn't textbox for password");
        isTrue(loginForm().pswLbl.isDisplayed(), "There isn't label 'Password'");
        isTrue(loginForm().submit.isDisplayed(), "There isn't button 'Enter'");
        areEquals(loginForm().loginLbl.getText(), "Login", "Login label has text 'Login'");
        areEquals(loginForm().pswLbl.getText(), "Password", "Password label has text 'Password'");
        areEquals(loginForm().submit.getText(), "ENTER", "Enter button has text 'Enter'");
        makeScreen();
    }
}
