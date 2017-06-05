package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JMenu;
import com.epam.tests_logic.elements.DblLevelMenu;
import com.epam.tests_logic.entity.User;
import com.epam.tests_logic.entity.Users;
import com.epam.tests_logic.enums.HeaderMenu;
import com.epam.tests_logic.ui.forms.LoginOnHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.LOGGED_IN;
import static com.epam.tests_logic.enums.States.LOG_IN_OUT_IS_OPENED;
import static com.epam.tests_logic.ui.TestSite.homePage;

public class HomePage extends WebPage{

    public LoginOnHomePage loginOnHomePage;

    @JFindBy(className = "profile-photo")
    public IButton profileBtn;

    @JFindBy(xpath = "//span[.='Logout']")
    public IButton logoutBtn;

    @JFindBy(css = ".profile-photo span")
    public IButton profileName;

    @JFindBy(className = "dropdown-menu-login")
    public Section logInOutPanel;

    @JMenu(jLevelLocators = {
            @JFindBy(xpath = "//nav/ul/li/a"),
            @JFindBy(xpath = "//nav/ul/li/ul/li/a")
    })
    public DblLevelMenu treeMenu;

    public void logIn(User user) {
        logger.info("LogIn");
        isInState(LOG_IN_OUT_IS_OPENED);
        loginOnHomePage.login(user);
    }
    public void logIn() {
        logIn(Users.DEFAULT);
    }
    public void logOut() {
        logger.info("LogOut");
        if(!logoutBtn.isDisplayed())
            profileBtn.click();
        logoutBtn.click();
    }
    public boolean isLoggedIn() {
        return profileName.isDisplayed();
    }
    public boolean isErrorLogin() {
        return loginOnHomePage.errorLbl.isDisplayed();
    }
    public boolean loginFormIsVisible(){
        return homePage.logInOutPanel.isDisplayed();
    }
    public void openLoginForm(){
        homePage.profileBtn.click();
    }
    public void openContactPage(){
        isInState(LOGGED_IN);
        homePage.treeMenu.clickAndClick("CONTACT FORM");
    }
    public void openDatesPage(){
        isInState(LOGGED_IN);
        homePage.treeMenu.clickAndClick("SERVICE|DATES");
    }


}
