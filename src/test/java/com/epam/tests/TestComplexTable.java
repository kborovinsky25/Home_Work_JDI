package com.epam.tests;

import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.tests_logic.entity.Areas;
import com.epam.tests_logic.entity.Skills;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.List;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.tests_logic.enums.States.COMPLEX_TABLE_PAGE;
import static com.epam.tests_logic.ui.TestSite.complexTablePage;
import static com.epam.web.matcher.testng.Assert.*;

/**
 * Created by Kirill_Borovinskii on 09.06.2017.
 */
@Title("Check page with Complex table")
public class TestComplexTable extends InitTests {
    private EntityTable<Areas, Skills> table(){
        return complexTablePage.complexTable;
    }

    @BeforeMethod
    public void setUpMethod(){
        logger.info("Open page and check it");
        isInState(COMPLEX_TABLE_PAGE);
    }
    @Test
    public void checkTableSize(){
        logger.info("Check the size of the table");
        complexTablePage.reestablish.click();
        areEquals(table().columns().count(), "4");
        areEquals(table().rows().count(), "8");
    }
    @Test
    public void checkTableContent(){
        logger.info("Check the contents of the table");
        complexTablePage.reestablish.click();
        List<Skills> rows = table().getRows(row -> row.Column1.title.getText().contains("Technologies"));
        areEquals(rows.size(), 2);
        areEquals(table().getRow(4).Column1.title.getValue(), "CVS", "Incorrect value in cell");
        areEquals(table().getRow(7).Column2.title.getValue(), "Chemistry", "Incorrect value in cell");
        areEquals(table().getRow(8).Column3.title.getValue(), "Sharepoint", "Incorrect value in cell");
        areEquals(table().getRow(1).HeaderRow.getValue(), "Microsoft Technologies", "Incorrect value in cell");
    }
    @Test
    public void checkCheckbox(){
        logger.info("Check working checkboxes");
        complexTablePage.reestablish.click();
        CheckBox checkbox = table().getRow(2).Column2.checkBox;
        isFalse(checkbox.isChecked(), "Checkbox is checked by default");
        checkbox.check();
        isTrue(checkbox.isChecked(), "Isn't worked Check for checkbox");
        checkbox.uncheck();
        isFalse(checkbox.isChecked(), "Isn't worked UnCheck for checkbox");
    }
    @Test
    public void checkLink(){
        logger.info("Check links");
        complexTablePage.reestablish.click();
        contains(table().getRow(2).Column1.linkMore.getURL().toString(), "#", "Incorrect url");
        contains(table().getRow(5).Column2.linkMore.getURL().toString(), "#", "Incorrect url");
        contains(table().getRow(8).Column3.linkMore.getURL().toString(), "#", "Incorrect url");
    }
}
