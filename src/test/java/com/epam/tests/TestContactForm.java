package com.epam.tests;

import com.epam.tests_logic.entity.User;
import com.epam.tests_logic.ui.forms.ContactOnContactPage;
import com.epam.tests_logic.ui.forms.ResultOnContactPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.CONTACT_PAGE;
import static com.epam.tests_logic.ui.TestSite.contactFormPage;
import static com.epam.web.matcher.testng.Assert.contains;

public class TestContactForm extends InitTests{
    private ResultOnContactPage result(){
        return contactFormPage.resultOnContactPage;
    }
    private ContactOnContactPage contact(){
        return contactFormPage.contactOnContactPage;
    }

    @BeforeMethod
    public void setUpMethod(){
        isInState(CONTACT_PAGE);
        logger.info("Open page Contact page");
    }
    @Test(dataProvider = "testContactPage", dataProviderClass = TestData.class)
    public void testContactForm(User user) {
        logger.info("Check the work of Contact page, fill fields and submit");
        contact().submit(user);
        contains(result().summary.getText(), "3", "incorrect count of operation");
        contains(result().name.getText(), user.name, "incorrect user name in result section");
        contains(result().lastName.getText(), user.lastName, "incorrect last name in result section");
        contains(result().description.getText(), user.description, "incorrect description in result section");
    }

}
