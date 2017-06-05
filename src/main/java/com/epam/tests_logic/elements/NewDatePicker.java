package com.epam.tests_logic.elements;

import com.epam.jdi.uitests.core.interfaces.common.IDatePicker;
import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import org.openqa.selenium.By;

/**
 * Created by Kirill_Borovinskii on 6/5/2017.
 */
public class NewDatePicker extends DatePicker implements IDatePicker{
    public NewDatePicker(){
        super();
    }
    public void open(){
        this.getWebElement().click();
    }

    public void clickPrev(){
        this.getDriver().findElement(By.cssSelector(".datepicker-days .prev")).click();
    }
    public void clickNext(){
        this.getDriver().findElement(By.cssSelector(".datepicker-days .next")).click();
    }
    public void setDate(String date){
        this.getDriver().findElement(By.xpath("//table/tbody/tr/td[@class='day' and .='" + date + "']")).click();
    }
    public String getDate(){
        return this.getDriver().findElement(By.cssSelector(".datepicker-days .datepicker-switch")).getText();
    }

}
