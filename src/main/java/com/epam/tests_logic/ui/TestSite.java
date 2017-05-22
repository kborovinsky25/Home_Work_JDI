package com.epam.tests_logic.ui;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.tests_logic.ui.pages.HomePage;
import com.epam.tests_logic.ui.pages.LoginPage;

@JSite(domain = "https://jdi-framework.github.io")
public class TestSite extends WebSite{

    @JPage(url = "/tests/index.htm", title = "Index Page")
    public static HomePage homePage;

    @JPage(url = "/tests/index.htm", title = "Index Page")
    public static LoginPage loginPage;


}
