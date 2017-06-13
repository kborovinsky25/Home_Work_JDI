package com.epam.tests_logic.entity;

import com.epam.jdi.uitests.core.interfaces.common.ICheckBox;
import com.epam.jdi.uitests.core.interfaces.common.ILink;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kirill_Borovinskii on 6/11/2017.
 */
public class SkillCell extends Section {
//    @FindBy(tagName = "label")
//    @FindBy(className = "checkbox")
    @FindBy(css = "input[type=checkbox]")
    public ICheckBox checkBox;
    @FindBy(tagName = "a")
    public Link linkMore;
    @FindBy(css = "p:not(.checkbox)")
    public IText title;
}
