package com.epam.tests_logic.elements;

import com.epam.commons.LinqUtils;
import com.epam.commons.PrintUtils;
import com.epam.jdi.uitests.core.interfaces.complex.IMenu;
import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.WebAnnotationsUtil;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JMenu;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DblLevelMenu extends Menu implements IMenu{
    public DblLevelMenu() {
        super();
    }

    public DblLevelMenu(By optionsNamesLocatorTemplate) {
        super(optionsNamesLocatorTemplate);
    }

    public DblLevelMenu(By optionsNamesLocatorTemplate, By allOptionsNamesLocator) {
        super(optionsNamesLocatorTemplate, allOptionsNamesLocator);
        this.menuLevelsLocators.add(optionsNamesLocatorTemplate);
    }

    public DblLevelMenu(List<By> menuLevelsLocators) {
        this.menuLevelsLocators = menuLevelsLocators;
    }


    private String separator = "\\|";

    public final void clickAndClick(String... names) {
        this.actions.select(PrintUtils.print(names, this.separator), (xva$0) -> {
            this.clickAndClickAction(new String[]{xva$0});
        });
    }

    protected void clickAndClickAction(String... names) {
        if(names != null && names.length != 0) {
            String[] split = this.SplitToList(names);
            if(split.length > this.menuLevelsLocators.size()) {
                throw JDISettings.exception("Can't click and click on element (%s) by value: %s. Amount of locators (%s) less than select path length (%s)",
                        new Object[]{this, PrintUtils.print(names, this.separator), Integer.valueOf(this.menuLevelsLocators.size()), Integer.valueOf(split.length)});
            } else {
                if(split.length > 1) {
//                    this.select((String[])Arrays.copyOfRange(split, 0, split.length - 1));
                    Selector selector_1 = new Selector((By)this.menuLevelsLocators.get(0));
                    selector_1.setParent(this.getParent());
                    selector_1.select(split[0]);
                }
                int lastIndex = split.length - 1;
                Selector selector = new Selector((By)this.menuLevelsLocators.get(lastIndex));
                selector.setParent(this.getParent());
                selector.select(split[lastIndex]);
            }
        }
    }

    public DblLevelMenu setUp(JMenu jMenu) {
        this.menuLevelsLocators = jMenu.levelLocators().length > 0? LinqUtils.select(Arrays.asList(jMenu.levelLocators()),
                WebAnnotationsUtil::findByToBy):LinqUtils.select(Arrays.asList(jMenu.jLevelLocators()), WebAnnotationsUtil::findByToBy);
        if(!jMenu.separator().equals("")) {
            this.separator = jMenu.separator();
        }
        return this;
    }
    private List<By> menuLevelsLocators = new ArrayList();

    private String[] SplitToList(String[] str) {
        return str.length == 1?str[0].split(this.separator):str;
    }

}
