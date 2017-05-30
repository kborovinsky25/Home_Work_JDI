package com.epam.tests_logic.ui.forms;

import com.epam.jdi.uitests.core.interfaces.common.ILabel;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.tests_logic.entity.User;

public class ResultOnContactPage extends Form<User> {
    public ResultOnContactPage(){
        super(User.class);
    }
    @JFindBy(className = "summ-res")
    public ILabel summary;

    @JFindBy(className = "name-res")
    public ILabel name;

    @JFindBy(className = "lname-res")
    public ILabel lastName;

    @JFindBy(className = "descr-res")
    public ILabel description;

}
