package eu.christineroels.unluckyDays;

import java.time.*;

public class UnluckyDays {
    //We are looking for how many fridays the 13th (bad fridays) there is in a month
    public static int unluckyDays(int year) {
        //Offset the amount of bad fridays to 0
        int badFridays = 0;
        //Offset the date to the first day of the year => January the 1st
        LocalDate date = LocalDate.ofYearDay(year, 1);
        //A method to determine a bad friday in a given month and update the total of bad fridays in a year
        badFridays = countBadFriday(date, badFridays);
        //In this loop, we will go from month to month in a year: starting from our offset
        //by adding a correct number of days to reach
        //to the next first day of the month
        do {
            if (date.getMonthValue() == 1 || date.getMonthValue() == 3 ||
                    date.getMonthValue() == 5 || date.getMonthValue() == 7 ||
                    date.getMonthValue() == 8 || date.getMonthValue() == 10 || date.getMonthValue() == 12) {
                date = date.plus(Period.ofDays(31));
                badFridays = countBadFriday(date, badFridays);
            } else if ((!date.isLeapYear()) && date.getMonthValue() == 2) {
                date = date.plus(Period.ofDays(28));
                badFridays = countBadFriday(date, badFridays);
            } else if ((date.isLeapYear()) && date.getMonthValue() == 2) {
                date = date.plus(Period.ofDays(29));
                badFridays = countBadFriday(date, badFridays);
            } else {
                date = date.plus(Period.ofDays(30
                ));
                badFridays = countBadFriday(date, badFridays);
            }
        } while (date.isBefore(LocalDate.of(year, 12,1)));
        return badFridays;
    }

    public static int countBadFriday(LocalDate date, int badFridays) {
        //If the first day of the month (according to our offset) is a Sunday then there will be a Friday the 13th
        if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            badFridays++;
        }
        return badFridays;
    }

}
