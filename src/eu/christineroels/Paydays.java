package be.intecbrussel.katas;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Paydays {
    public static void main(String[] args) {
        //Fluent aka methods chaining
        LocalDate today = LocalDate.now();
        //Paydays comes two days before the last day of the month
        LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println(payday);
    }
}
