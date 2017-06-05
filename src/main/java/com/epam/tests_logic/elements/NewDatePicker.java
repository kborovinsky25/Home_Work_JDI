package com.epam.tests_logic.elements;

import com.epam.jdi.uitests.core.interfaces.common.IDatePicker;
import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import org.openqa.selenium.By;

import static com.epam.tests_logic.Utils.getXpath;

/**
 * Created by Kirill_Borovinskii on 6/5/2017.
 */
public class NewDatePicker extends DatePicker implements IDatePicker{
    public NewDatePicker(){
        super();
    }

    private By btnPrev = new By.ByCssSelector(".datepicker-days .prev");
    private By btnNext = new By.ByCssSelector(".datepicker-days .next");
    private By elementOfTable = new By.ByXPath("//table/tbody/tr/td[@class='day']");
    private By btnTitle = new By.ByCssSelector(".datepicker-days .datepicker-switch");
    private String selectedElementXpath =  "//table/tbody/tr/td[@class='day' and .='%s']";

    public void open(){
        this.getWebElement().click();
    }
    public void clickPrev(){
        this.getDriver().findElement(btnPrev).click();
    }
    public void clickNext(){
        this.getDriver().findElement(btnNext).click();
    }
    public void setDate(String date){
        this.getDriver().findElement(getXpath(selectedElementXpath, date)).click();
    }
    public String getTitle(){
        return this.getDriver().findElement(btnTitle).getText();
    }
    public String getElementOfTable(){
        return this.getDriver().findElement(elementOfTable).getText();
    }
    public void setLevel(){

    }

}
