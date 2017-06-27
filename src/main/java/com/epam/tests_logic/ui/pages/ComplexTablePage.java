package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import com.epam.tests_logic.entity.Areas;
import com.epam.tests_logic.entity.Skills;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.TableHeaderTypes.ALL_HEADERS;
import static com.epam.tests_logic.ui.TestSite.complexTablePage;

/**
 * Created by Kirill_Borovinskii on 09.06.2017.
 */
public class ComplexTablePage extends WebPage{
    @JTable(root = @FindBy(css = "table.table-delete-body"),
            headerType = ALL_HEADERS,
            headers = @FindBy(xpath = "//thead/tr"),
            colStartIndex = 2,
            cell = @FindBy(xpath = "//tbody/tr[{1}]/td[{0}]"))
    public EntityTable<Areas, Skills> complexTable =
            new EntityTable<>(Areas.class, Skills.class);

    @JFindBy(xpath = "//button[.='Reestablish']")
    public IButton reestablish;

    public boolean isOpen() {
        return complexTablePage.verifyOpened();
    }
}
