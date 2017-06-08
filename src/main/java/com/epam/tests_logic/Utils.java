package com.epam.tests_logic;

import com.epam.tests_logic.entity.Date;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Formatter;

/**
 * Created by Kirill_Borovinskii on 05.06.2017.
 */
public class Utils {
    public static By.ByXPath getXpath(String xpath, String variable) {
        return new By.ByXPath(fillString(xpath, variable));
    }
    public static By.ByCssSelector getCss(String css, String variable){
        return new By.ByCssSelector(fillString(css, variable));
    }
    public static String fillString(String line, String variable){
        Formatter f = new Formatter();
        return f.format(line, variable).toString();
    }
    public static Date splitTo(String input, String regex){
        int[] numArr = Arrays.stream(input.split(regex)).mapToInt(Integer::parseInt).toArray();
        return new Date(numArr[1], numArr[0], numArr[2]);
    }

}
