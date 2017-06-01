package com.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.entity.Users.DEFAULT;
import static com.epam.tests_logic.enums.States.CONTACT_PAGE;
import static com.epam.tests_logic.ui.TestSite.contactOnContactPage;
import static com.epam.tests_logic.ui.TestSite.resultOnContactPage;
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
        contactOnContactPage.submit(DEFAULT);
        contains(resultOnContactPage.summary.getText(), "3");
        contains(resultOnContactPage.name.getText(), DEFAULT.name);
        contains(resultOnContactPage.lastName.getText(), DEFAULT.lastName);
        contains(resultOnContactPage.description.getText(), DEFAULT.description);
    }

}
