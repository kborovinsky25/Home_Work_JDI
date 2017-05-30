package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.IMenu;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JMenu;
import com.epam.tests_logic.enums.HeaderMenu;
import com.epam.tests_logic.ui.forms.LoginOnHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.ui.TestSite.homePage;

public class HomePage extends WebPage{

    public LoginOnHomePage loginOnHomePage;

    @JFindBy(className = "profile-photo")
    public IButton profileBtn;

    @JFindBy(xpath = "//span[contains(text(),'Logout')]")
    public IButton logoutBtn;

    @JFindBy(className = "navbar-right")
    public IButton profileDDBtn;

    @JFindBy(xpath = "//span[contains(text(),'Contact form')]")
    public IButton navToContactPage;

    @JMenu(levelLocators = {
            @FindBy(xpath = "//ul/li/a"),
            @FindBy(xpath = "//ul/li/ul/li/a")
    })
    public Menu treeMenu;

    public void menuDblClick(String lvl1, String lvl2){
        Actions action = new Actions(getDriver());
        WebElement el1 = getDriver().findElement(By.xpath("//ul/li/a[contains(text(),'" + lvl1 + "')]"));
        WebElement el2 = getDriver().findElement(By.xpath("//ul/li/ul/li/a[contains(text(),'" + lvl2 + "')]"));
        action.moveToElement(el1).click().moveToElement(el2).click().build().perform();

    }

    @JFindBy(xpath = "//ul/li/a")
    public Menu menu;

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
