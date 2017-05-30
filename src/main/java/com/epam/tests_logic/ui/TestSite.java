package com.epam.tests_logic.ui;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.tests_logic.ui.pages.ContactFormPage;
import com.epam.tests_logic.ui.pages.DatePage;
import com.epam.tests_logic.ui.pages.HomePage;
import com.epam.tests_logic.ui.pages.SimpleTablePage;

@JSite(domain = "https://jdi-framework.github.io/tests")
public class TestSite extends WebSite{

    @JPage(url = "/", title = "Index Page")
    public static HomePage homePage;

    @JPage(url = "/page1.htm", title = "Contact Form")
    public static ContactFormPage contactFormPage;

    @JPage(url = "/page4.htm", title = "Dates")
    public static DatePage datePage;

    @JPage(url = "/page6.htm", title = "Simple Table")
    public static SimpleTablePage simpleTablePage;
}
