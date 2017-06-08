package com.epam.tests_logic.elements;

import com.epam.jdi.uitests.core.interfaces.common.IDatePicker;
import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import com.epam.tests_logic.entity.Date;
import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.tests_logic.Utils.getCss;
import static com.epam.tests_logic.Utils.getXpath;
import static com.epam.tests_logic.Utils.splitTo;
import static com.epam.tests_logic.entity.Date.*;

/**
 * Created by Kirill_Borovinskii on 6/5/2017.
 */
public class NewDatePicker extends DatePicker implements IDatePicker{
    public NewDatePicker(){
        super();
    }

    private By level = new By.ByXPath("//body/div[2]//*[@style='display: block;']");
    private By closeElement = new By.ByClassName("row");

    private String selectedElementXpath =  "//table/tbody/tr//*[.='%s' and @class!='old day' and @class!='new day']";
    private String selectTitleCss = ".datepicker-%s .datepicker-switch";
    private String btnPrev = ".datepicker-%s .prev";
    private String btnNext = ".datepicker-%s .next";

    private final String dateRegex = "[/]";
    private final String rangeRegex = "[-]";
    private final String lvlRegex = "[a-z]*$";

    public void open(){
        this.getWebElement().click();
    }
    public void close(){
        this.getDriver().findElement(closeElement).click();
    }
    public void newInput(String date){
        this.getWebElement().clear();
        this.getWebElement().sendKeys(date);
        close();
    }
    public void clickPrev(){
        this.getDriver().findElement(getCss(btnPrev, getLevel())).click();
    }
    public void clickNext(){
        this.getDriver().findElement(getCss(btnNext, getLevel())).click();
    }
    public void setDate(String date){
        Date input = splitTo(date, dateRegex);
        close();
        open();
        this.getDriver().findElement(getCss(selectTitleCss, "days")).click();
        this.getDriver().findElement(getCss(selectTitleCss, "months")).click();
        while (input.year < getYearsRange(0) || input.year > getYearsRange(1)){
            if (input.year < getYearsRange(0)){
                clickPrev();
            }
            else {
                clickNext();
            }
        }
        setUnit(String.valueOf(input.year));
        setUnit(toShortForm(input.month));
        setUnit(String.valueOf(input.day));
        close();
    }
    public String getTitle(){
        return this.getDriver().findElement(getCss(selectTitleCss, getLevel())).getText();
    }
    private void setUnit(String unit){
        this.getDriver().findElement(getXpath(selectedElementXpath, unit)).click();
    }
    private String getLevel(){
        final Pattern pattern = Pattern.compile(lvlRegex);
        final Matcher matcher = pattern.matcher(this.getDriver().findElement(level).getAttribute("class"));
        matcher.find();
        return matcher.group();
    }
    private int getYearsRange(int i){
        int[] range = Arrays.stream(getTitle().split(rangeRegex)).mapToInt(Integer::parseInt).toArray();
        return range[i];
    }




}
