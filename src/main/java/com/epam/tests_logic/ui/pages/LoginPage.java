package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ILabel;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;


public class LoginPage extends WebPage {
    @JFindBy(css = "[for=Login]")
    public ILabel loginLbl;

    @JFindBy(id = "Login")
    public ITextField loginInp;

    @JFindBy(css = "[for=Password]")
    public ILabel pswLbl;

    @JFindBy(id = "Password")
    public ITextField pswInp;

    @JFindBy(xpath = "//span[contains(text(),'Enter')]")
    public IButton submit;

    @JFindBy(className = "login-txt")
    public ILabel errorLbl;

    public void credentialsInput(String login, String psw) {
        logger.info("Input credentials");
        loginInp.newInput(login);
        pswInp.newInput(psw);
    }
}
