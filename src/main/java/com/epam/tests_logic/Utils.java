package com.epam.tests_logic;

import org.openqa.selenium.By;

import java.util.Formatter;

/**
 * Created by Kirill_Borovinskii on 05.06.2017.
 */
public class Utils {
    public static By.ByXPath getXpath(String xpath, String variable) {
        return new By.ByXPath(fillString(xpath, variable));
    }

    public static String fillString(String line, String variable){
        Formatter f = new Formatter();
        return f.format(line, variable).toString();
    }

//    public static Boolean reg(){
//        \d{4}$
//                ^\d{4}
//[a-zA-Z]+
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//        final String regex = "^[a-zA-Z]+";
//        final String string = "February 2017";
//
//        final Pattern pattern = Pattern.compile(regex);
//        final Matcher matcher = pattern.matcher(string);
//
//        while (matcher.find()) {
//            System.out.println("Full match: " + matcher.group(0));
//            for (int i = 1; i <= matcher.groupCount(); i++) {
//                System.out.println("Group " + i + ": " + matcher.group(i));
//            }
//        }
//    }
}
