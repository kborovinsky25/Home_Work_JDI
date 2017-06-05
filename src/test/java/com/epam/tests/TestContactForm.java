package com.epam.tests;

import com.epam.tests_logic.entity.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.CONTACT_PAGE;
import static com.epam.tests_logic.ui.TestSite.contactFormPage;
import static com.epam.tests_logic.ui.TestSite.homePage;
import static com.epam.web.matcher.testng.Assert.contains;

public class TestContactForm extends InitTests{
    @BeforeMethod
    public void setUpMethod(){
        isInState(CONTACT_PAGE);
        logger.info("Open page Contact page");
    }

    @Test(dataProvider = "testContactPage", dataProviderClass = TestData.class)
    public void testContactForm(User user) {
        logger.info("Check the work of Contact page");
        contactFormPage.contactOnContactPage.submit(user);
        contains(contactFormPage.resultOnContactPage.summary.getText(), "3");
        contains(contactFormPage.resultOnContactPage.name.getText(), user.name);
        contains(contactFormPage.resultOnContactPage.lastName.getText(), user.lastName);
        contains(contactFormPage.resultOnContactPage.description.getText(), user.description);
    }

}
