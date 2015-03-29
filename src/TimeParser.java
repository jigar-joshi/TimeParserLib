
import java.util.Calendar;

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

    
    private int getHourOfDay(String input){
        
        int day = 0;
        Calendar calendar;
        switch (input.toLowerCase()) {
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
            case "day after tomorrow":
                calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_WEEK) + 2;
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

        int askedDay = getDayOfTheWeek(inputString);
        if (day <= askedDay) {
            return askedDay - day;
        } else {
            return (askedDay + 7) - day;
        }
    }

}
