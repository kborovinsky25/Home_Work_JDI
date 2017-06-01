package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JMenu;
import com.epam.tests_logic.entity.User;
import com.epam.tests_logic.entity.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.LOGGED_IN;
import static com.epam.tests_logic.enums.States.LOG_IN_OUT_IS_OPENED;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.tests_logic.ui.TestSite.loginOnHomePage;

public class HomePage extends WebPage{

    @JFindBy(className = "profile-photo")
    public IButton profileBtn;

    @JFindBy(xpath = "//span[.='Logout']")
    public IButton logoutBtn;

    @JFindBy(css = ".profile-photo span")
    public IButton profileName;

    @JFindBy(xpath = "//span[contains(text(),'Contact form')]")
    public IButton navToContactPage;

    @JFindBy(className = "dropdown-menu-login")
    public Section logInOutPanel;

    @JMenu(levelLocators = {
            @FindBy(xpath = "//ul/li/a"),
            @FindBy(xpath = "//ul/li/ul/li/a")
    })
    public Menu treeMenu;

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
    //переделать на новый метод меню
    public void openContactPage(){
        isInState(LOGGED_IN);
        homePage.navToContactPage.click();
    }

    public void menuDblClick(String lvl1, String lvl2){
        Actions action = new Actions(getDriver());
        WebElement el1 = getDriver().findElement(By.xpath("//ul/li/a[contains(text(),'" + lvl1 + "')]"));
        WebElement el2 = getDriver().findElement(By.xpath("//ul/li/ul/li/a[contains(text(),'" + lvl2 + "')]"));
        action.moveToElement(el1).click().moveToElement(el2).click().build().perform();

    }


    public void openLoginPage() {
        logger.info("Open Login page");
        if (!loginOnHomePage.submit.isDisplayed()){
            if (!homePage.profileBtn.getText().equalsIgnoreCase("")) {
                logger.info("Need logout");
                if (!logoutBtn.isDisplayed()) {
                    profileBtn.click();
                    logoutBtn.click();
                } else {
                    logoutBtn.click();
                }
            }
            else {
                profileBtn.click();
            }
        }
    }
}
