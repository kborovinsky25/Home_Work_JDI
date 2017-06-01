package com.epam.tests;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.tests_logic.ui.TestSite;
import org.testng.annotations.BeforeSuite;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.ui.TestSite.homePage;

public class InitTests extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(TestSite.class);
        logger.info("Run Tests");
//        homePage.shouldBeOpened();
        homePage.open();
    }
}
