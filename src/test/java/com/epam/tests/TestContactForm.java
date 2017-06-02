package com.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.entity.Users.DEFAULT;
import static com.epam.tests_logic.enums.States.CONTACT_PAGE;
import static com.epam.tests_logic.ui.TestSite.contactFormPage;
import static com.epam.web.matcher.testng.Assert.contains;

public class TestContactForm extends InitTests{
    @BeforeMethod
    public void setUpMethod(){
        isInState(CONTACT_PAGE);
        logger.info("Open page Contact page");
    }

    @Test
    public void testContactForm() {
        logger.info("Check the work of Contact page");
        contactFormPage.contactOnContactPage.submit(DEFAULT);
        contains(contactFormPage.resultOnContactPage.summary.getText(), "3");
        contains(contactFormPage.resultOnContactPage.name.getText(), DEFAULT.name);
        contains(contactFormPage.resultOnContactPage.lastName.getText(), DEFAULT.lastName);
        contains(contactFormPage.resultOnContactPage.description.getText(), DEFAULT.description);
    }

}
