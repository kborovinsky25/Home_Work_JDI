package com.epam.tests_logic.ui;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.tests_logic.ui.pages.*;

@JSite(domain = "https://epam.github.io/JDI/")
public class TestSite extends WebSite{

    @JPage(url = "/index.htm", title = "Index Page")
    public static HomePage homePage;

    @JPage(url = "/page1.htm", title = "Contact Form")
    public static ContactFormPage contactFormPage;

    @JPage(url = "/page4.htm", title = "Dates")
    public static DatePage datesPage;

    @JPage(url = "/page6.htm", title = "Simple Table")
    public static SimpleTablePage simpleTablePage;

    @JPage(url = "/page5.htm", title = "Complex Table")
    public static ComplexTablePage complexTablePage;

}
