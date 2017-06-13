package com.epam.tests_logic.ui.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ICheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import com.epam.tests_logic.entity.Areas;
import com.epam.tests_logic.entity.Skills;
import com.epam.tests_logic.enums.DropList;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.TableHeaderTypes.ALL_HEADERS;
import static com.epam.tests_logic.ui.TestSite.complexTablePage;

/**
 * Created by Kirill_Borovinskii on 09.06.2017.
 */
public class ComplexTablePage extends WebPage{
    @JTable(root = @FindBy(css = "table.table-delete-body"),
//            row = @FindBy(xpath = "//tbody/tr[%s]/td"),
//            column = @FindBy(xpath = "//tbody/tr/td[%s]"),
            headerType = ALL_HEADERS,
            headers = @FindBy(xpath = "//thead/tr"),
            colStartIndex = 2,
            cell = @FindBy(xpath = "//tbody/tr[{1}]/td[{0}]"))
    public EntityTable<Areas, Skills> complexTable =
            new EntityTable<>(Areas.class, Skills.class);

    @JFindBy(xpath = "//button[.='Reestablish']")
    public IButton reestablish;
    @JFindBy(xpath = "//button[.='Apply']")
    public IButton apply;
    @JDropdown(root = @FindBy(xpath = "//*[@id='columns']/div/button"))
//            jList = @JFindBy(css = ".dropdown-menu.open>ul>li>a>span"),
//            jExpand = @JFindBy(css = ".btn.dropdown-toggle"),
//            jValue = @JFindBy(css = ".dropdown-menu.open"))
    public Dropdown<DropList> dropMenu;

    public boolean isOpen() {
        return complexTablePage.verifyOpened();
    }
}
