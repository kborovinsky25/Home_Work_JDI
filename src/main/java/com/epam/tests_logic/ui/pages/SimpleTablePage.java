package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.TableHeaderTypes.ROWS_HEADERS;

public class SimpleTablePage extends WebPage{
    @JTable(root = @FindBy(className = "tbl-without-header"),
    row = @FindBy(xpath = ".//tbody/tr[%s]/td"),
    column = @FindBy(xpath = ".//tbody/tr/td[%s]"),
    headerType = ROWS_HEADERS,
    colStartIndex = 2,
    cell = @FindBy(xpath = ".//tbody/tr[{1}]/td[{0}]"),
    rowNames = @FindBy(xpath = "//td"))
    public Table sTable;
}
