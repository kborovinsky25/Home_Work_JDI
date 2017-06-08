package com.epam.tests_logic.entity;

/**
 * Created by Kirill_Borovinskii on 07.06.2017.
 */
public class Date {
    public int day;
    public int month;
    public int year;

    public Date(){}
    public Date(int month){
        this.month = month;
    }

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static String toShortForm(int month){
        switch (month){
            case 1: return "Jan";
            case 2: return "Feb";
            case 3: return "Mar";
            case 4: return "Apr";
            case 5: return "May";
            case 6: return "Jun";
            case 7: return "Jul";
            case 8: return "Aug";
            case 9: return "Sep";
            case 10: return "Oct";
            case 11: return "Nov";
            case 12: return "Dec";
        }
        return "Dec";
    }
}
