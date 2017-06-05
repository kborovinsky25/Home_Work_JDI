package com.epam.tests_logic.elements;

import com.epam.jdi.uitests.core.interfaces.common.IDatePicker;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.WebAnnotationsUtil;
import com.epam.tests_logic.annotations.MDatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyDatePicker extends DatePicker implements IDatePicker{
    private By textField;
    private By prev;

    public MyDatePicker() {
        super();
    }

    public MyDatePicker(By byLocator) {
        super(byLocator);
    }

    public MyDatePicker(WebElement webElement) {
        super(webElement);
    }

    public MyDatePicker setUp(MDatePicker datePicker){
        By textField = WebAnnotationsUtil.findByToBy(datePicker.textField());
        By prev = WebAnnotationsUtil.findByToBy(datePicker.prev());
        By next = WebAnnotationsUtil.findByToBy(datePicker.next());
        System.out.println("----------------------------------------");
        System.out.println(textField);

        if(textField != null) {
            Element el = new Element(textField);
            el.setParent(this.getParent());
            this.setParent(el);
            this.setAvatar(textField);
        }

//        this.textField = textField;
//        this.prev = prev;

        return this;
    }

    public void open(){
        System.out.println(this);
        System.out.println(this.textField);
        get(textField).click();
//        this.get(textField).click();
    }

    public void clickPrev(){
        this.get(prev).click();
    }
}
