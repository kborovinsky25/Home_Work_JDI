package com.epam.tests_logic.entity;

import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kirill_Borovinskii on 6/11/2017.
 */
public class SkillCell extends Section {
    @FindBy(className = "checkbox")
    public CheckBox checkBox = new CheckBox() {
        @Override
        protected boolean isCheckedAction() {
            return getWebElement().findElement(By.tagName("input")).getAttribute("checked") != null;
        }

    };
    @FindBy(tagName = "a")
    public Link linkMore;
    @FindBy(css = "p:not(.checkbox)")
    public IText title;


}
