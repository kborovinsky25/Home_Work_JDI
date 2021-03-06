package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import com.epam.tests_logic.entity.SimpleTableElement;
import org.openqa.selenium.support.FindBy;
import static com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.TableHeaderTypes.ROWS_HEADERS;
import static com.epam.tests_logic.ui.TestSite.simpleTablePage;

public class SimpleTablePage extends WebPage{
    @JTable(root = @FindBy(tagName = "table"),
    row = @FindBy(xpath = ".//tbody/tr[%s]/td"),
    column = @FindBy(xpath = ".//tbody/tr/td[%s]"),
    headerType = ROWS_HEADERS,
    headers = @FindBy(xpath = "//table//tr[1]/td"),
    colStartIndex = 2,                                      //does it work???
    cell = @FindBy(xpath = ".//tbody/tr[{1}]/td[{0}]"),
    rowNames = @FindBy(xpath = "//table//tr/td[1]"))
    public EntityTable<SimpleTableElement, ?> simpleTable =
            new EntityTable<>(SimpleTableElement.class, Object.class);

    public boolean isOpen() {
        return simpleTablePage.verifyOpened();
    }
}
