package com.epam.tests_logic.annotations;

import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import org.openqa.selenium.support.FindBy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Kirill_Borovinskii on 6/4/2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface MDatePicker {
    FindBy textField() default @FindBy;
    JFindBy jTextField() default @JFindBy;

    FindBy prev() default @FindBy;
    JFindBy jPrev() default @JFindBy;

    FindBy next() default @FindBy;
    JFindBy jNext() default @JFindBy;
}
