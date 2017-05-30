package com.epam.tests;

import com.epam.tests_logic.entity.User;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.ui.TestSite.contactFormPage;
import static com.epam.tests_logic.ui.TestSite.homePage;

public class TestContactForm extends InitTests{
    @BeforeMethod
    public void setUpMethod(){
        homePage.shouldBeOpened();
        logger.info("Open page and check it");

    }

    @Test(dataProvider = "userEntity", dataProviderClass = TestData.class)
    public void testContactForm(User user) {
        homePage.treeMenu.select("");
        logger.info("Check the work of Contact page");
        homePage.openLoginPage();
        homePage.loginOnHomePage.submit(user);
        homePage.menu.clickOn("Contact form");
//        homePage.navToContactPage.click();
        contactFormPage.contactOnContactPage.submit(user);
        Assert.contains(contactFormPage.resultOnContactPage.summary.getText(), "3");
//        assertEquals(contactFormPage.resultOnContactPage.summary.getText(), "Summary: 3");
        Assert.contains(contactFormPage.resultOnContactPage.name.getText(), user.name);
//        assertEquals(contactFormPage.resultOnContactPage.name.getText(), "Name: " + user.name);
        Assert.contains(contactFormPage.resultOnContactPage.lastName.getText(), user.lastName);
//        assertEquals(contactFormPage.resultOnContactPage.lastName.getText(), "Last Name: " + user.lastName);
        Assert.contains(contactFormPage.resultOnContactPage.description.getText(), user.description);
//        assertEquals(contactFormPage.resultOnContactPage.description.getText(), "Description: " + user.description);
    }

}
