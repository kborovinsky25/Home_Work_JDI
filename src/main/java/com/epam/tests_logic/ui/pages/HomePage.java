package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.IMenu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JMenu;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.tests_logic.ui.TestSite.loginPage;

public class HomePage extends WebPage{

    @JFindBy(className = "profile-photo")
    public IButton profileBtn;

    @JFindBy(xpath = "//span[contains(text(),'Logout')]")
    public IButton logoutBtn;

    @JFindBy(className = "navbar-right")
    public IButton profileDDBtn;

    public void openLoginPage() {
        logger.info("Open Login page");
        if (!loginPage.submit.isDisplayed()){
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
