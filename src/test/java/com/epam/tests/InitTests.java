package com.epam.tests;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.tests_logic.ui.TestSite;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.ui.TestSite.homePage;

public class InitTests extends TestNGBase {
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        WebSite.init(TestSite.class);
        homePage.shouldBeOpened();
        logger.info("Run Tests");

    }

    @AfterMethod
    public void tearDown() {
        Verify.getFails();
    }
}
