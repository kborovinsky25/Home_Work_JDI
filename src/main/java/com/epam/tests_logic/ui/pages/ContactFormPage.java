package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.tests_logic.ui.forms.ContactOnContactPage;
import com.epam.tests_logic.ui.forms.ResultOnContactPage;

public class ContactFormPage extends WebPage{
    public ContactOnContactPage contactOnContactPage;
    public ResultOnContactPage resultOnContactPage;

    @JFindBy(css = ".results")
    public TextList<Enum> resultsForm;
}
