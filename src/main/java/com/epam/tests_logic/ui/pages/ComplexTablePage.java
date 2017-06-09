package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.TableHeaderTypes.COLUMNS_HEADERS;
import static com.epam.tests_logic.ui.TestSite.complexTablePage;

/**
 * Created by Kirill_Borovinskii on 09.06.2017.
 */
public class ComplexTablePage extends WebPage{
    @JTable(root = @FindBy(css = "table.table-delete-body"),
            row = @FindBy(xpath = ".//tbody/tr[%s]/td"),
            column = @FindBy(xpath = ".//tbody/tr/td[%s]"),
            headerType = COLUMNS_HEADERS,
            headers = @FindBy(tagName = "thead"),
            cell = @FindBy(xpath = ".//tbody/tr[{1}]/th[{0}]"))
    public ITable complexTable;

    public boolean isOpen() {
        return complexTablePage.verifyOpened();
    }
}
