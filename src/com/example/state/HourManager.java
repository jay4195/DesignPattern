package com.example.state;

public class HourManager {

    public enum Period {
        DAY,
        LUNCH,
        NIGHT
    }

    public static Period getPeriod(int hour) {
        if (hour < 8 || hour >= 21) {
            return Period.NIGHT;
        } else if (hour == 12) {
            return Period.LUNCH;
        } else {
            return Period.DAY;
        }
    }
}
