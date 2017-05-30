package com.epam.tests_logic.ui.forms;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ILabel;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.tests_logic.entity.User;

public class ContactOnContactPage extends Form<User>{
    public ContactOnContactPage(){
        super(User.class);
    }

    @JFindBy(id = "Name")
    public ITextField name;

    @JFindBy(css = "[for=Name]")
    public ILabel nameLbl;

    @JFindBy(id = "LastName")
    public ITextField lastName;

    @JFindBy(css = "[for=LastName]")
    public ILabel lastNameLbl;

    @JFindBy(id = "Description")
    public ITextField description;

    @JFindBy(css = "[for=Description]")
    public ILabel descrLbl;

    @JFindBy(xpath = "//button[contains(text(),'Submit')]")
    public IButton submit;
}
