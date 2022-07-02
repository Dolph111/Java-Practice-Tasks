package com.task;
import java.util.List;

public class DateTime {
    public final int day;
    public final int month;
    public final int year;
    public final int hours;
    public final int minutes;
    public final int seconds;

    public DateTime(int day, int month, int year, int hours, int minutes, int seconds) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
