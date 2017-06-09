package com.epam.tests;

import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ITable;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.COMPLEX_TABLE_PAGE;
import static com.epam.tests_logic.ui.TestSite.complexTablePage;

/**
 * Created by Kirill_Borovinskii on 09.06.2017.
 */
public class TestComplexTable extends InitTests {
    private ITable table(){
        return complexTablePage.complexTable;
    }

    @BeforeMethod
    public void setUpMethod(){
        logger.info("Open page and check it");
        isInState(COMPLEX_TABLE_PAGE);
    }
    @Test
    public void testContentSimpleTable() {

    }
}
