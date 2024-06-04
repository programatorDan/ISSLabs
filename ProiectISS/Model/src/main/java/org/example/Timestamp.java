package org.example;

public class Timestamp {
    private double Seconds;
    private int Minutes;
    private int Hours;

    public Timestamp(double seconds, int minutes, int hours) {
        Seconds = seconds;
        Minutes = minutes;
        Hours = hours;
    }

    public double getSeconds() {
        return Seconds;
    }

    public void setSeconds(double seconds) {
        Seconds = seconds;
    }

    public int getMinutes() {
        return Minutes;
    }

    public void setMinutes(int minutes) {
        Minutes = minutes;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int hours) {
        Hours = hours;
    }
}
