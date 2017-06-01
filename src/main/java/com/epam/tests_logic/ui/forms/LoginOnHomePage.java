package com.epam.tests_logic.ui.forms;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ILabel;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.tests_logic.entity.User;


public class LoginOnHomePage extends Form<User> {

    public LoginOnHomePage(){
        super(User.class);
    }

    @JFindBy(css = "[for=Login]")
    public ILabel loginLbl;

    @JFindBy(id = "Login")
    public ITextField name;

    @JFindBy(css = "[for=Password]")
    public ILabel pswLbl;

    @JFindBy(id = "Password")
    public ITextField psw;

    @JFindBy(xpath = "//span[.='Enter']")
    public IButton submit;

    @JFindBy(className = "login-txt")
    public ILabel errorLbl;

}
