package TimeParserCustom;


import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jigar / Mithilesh
 */

public class TimeParser {
    
//    public static void main(String[] args){
//        TimeParser t = new TimeParser();
//        System.out.println(t.getDateByDayOfTheWeek("remind me to call on monday at 4 AM"));
//        System.out.println(t.getDateByTime("remind me to call at noon"));
//        System.out.println(t.getDateByTime("remind me to call at friday 12 o'clock"));
//    }
    
    public Date getDateByTimeIntervals(String input, Date d){
        if(input.toLowerCase().contains("noon")){
            d.setHours(12);
            d.setMinutes(0);
            d.setSeconds(0);
        } else if(input.toLowerCase().contains("early morning")){
            d.setHours(6);
            d.setMinutes(30);
            d.setSeconds(0);
        }  else if(input.toLowerCase().contains("late morning")){
            d.setHours(11);
            d.setMinutes(0);
            d.setSeconds(0);
        } else if(input.toLowerCase().contains("morning")){
            d.setHours(9);
            d.setMinutes(0);
            d.setSeconds(0);
        } else if(input.toLowerCase().contains("midnight")){
            d.setHours(0);
            d.setMinutes(0);
            d.setSeconds(0);
        } else if(input.toLowerCase().contains("evening")){
            d.setHours(17);
            d.setMinutes(0);
            d.setSeconds(0);
        } else if(input.toLowerCase().contains("night")){
            d.setHours(21);
            d.setMinutes(0);
            d.setSeconds(0);
        }
        return d;
    }
    
    public Date getDateByTime(String input){
        String test = new Scanner(input).findInLine("(1[012]|[1-9])(:[0-5][0-9])?(\\s)?(?i)(am|pm|a.m.|p.m.|o'clock)?");
        Date d = this.getDateByDayOfTheWeek(input);
        if(test!=null){
            String[] tokensVal = null;
            if(test.contains(":")){
                tokensVal = test.split("(:|(\\s))");
            } else {
                tokensVal = test.split("(\\s)");
            }
            int i = tokensVal.length;
            if(i==3){
                if(tokensVal[2].equalsIgnoreCase("p.m.") || tokensVal[2].equalsIgnoreCase("pm")){
                    d.setHours(Integer.parseInt(tokensVal[0])+12);
                    d.setMinutes(Integer.parseInt(tokensVal[1]));
                } else {
                    d.setHours(Integer.parseInt(tokensVal[0]));
                    d.setMinutes(Integer.parseInt(tokensVal[1]));
                }
            } else if(i==2) {
                if(tokensVal[1].equalsIgnoreCase("p.m.") || tokensVal[1].equalsIgnoreCase("pm")){
                    d.setHours(Integer.parseInt(tokensVal[0])+12);
                    d.setMinutes(0);
                } else {
                    d.setHours(Integer.parseInt(tokensVal[0]));
                    d.setMinutes(0);
                }
            }
            d.setSeconds(0);
        } else {
            d = this.getDateByTimeIntervals(input, d);
        }
        return d;
    }
    
    public Date getDateByDayOfTheWeek(String date){
        Date d = new Date();
        d.setDate(d.getDate()+this.getDay(date));
        return d;
    }
    
    private int getDayOfTheWeek(String dayOfTheWeek) {
        int day = 0;
        Calendar calendar;
        switch (dayOfTheWeek.toLowerCase()) {
            case "sunday":
                day = Calendar.SUNDAY;
                break;
            case "monday":
                day = Calendar.MONDAY;
                break;
            case "tuesday":
                day = Calendar.TUESDAY;
                break;
            case "wednesday":
                day = Calendar.WEDNESDAY;
                break;
            case "thursday":
                day = Calendar.THURSDAY;
                break;
            case "friday":
                day = Calendar.FRIDAY;
                break;
            case "saturday":
                day = Calendar.SATURDAY;
                break;
            case "tomorrow":
                calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_WEEK) + 1;
                break;
            case "today":
                calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_WEEK);
                break;
            default:
                calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_WEEK);
                break;
        }
        return day;
    }
    
    private int getDay(String inputString) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        int askedDay = getDayOfTheWeek(this.getWeekDay(inputString));
        if (day <= askedDay) {
            return askedDay - day;
        } else {
            return (askedDay + 7) - day;
        }
    }
    
    private String getWeekDay(String inputString){
        if (inputString.contains("Sunday") || inputString.contains("sunday"))
        {
            return "Sunday";
        }
        else if (inputString.contains("Monday") || inputString.contains("monday"))
        {
            return "Monday";
        }
        else if (inputString.contains("Tuesday") || inputString.contains("tuesday"))
        {
            return "Tuesday";
        }
        else if (inputString.contains("Wednesday") || inputString.contains("wednesday"))
        {
            return "Wednesday";
        }
        else if (inputString.contains("Thursday") || inputString.contains("thursday"))
        {
            return "Thursday";
        }
        else if (inputString.contains("Friday") || inputString.contains("friday"))
        {
            return "Friday";
        }
        else if (inputString.contains("Saturday") || inputString.contains("saturday"))
        {
            return "Saturday";
        }
        else if (inputString.contains("Tomorrow") || inputString.contains("tomorrow"))
        {
            return "Tomorrow";
        }
        else
        {
            return "Today";
        }
    }
    
}
