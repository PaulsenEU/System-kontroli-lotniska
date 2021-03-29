package com.company.objects;

public class Date {

    private int departure_day, arrival_day, year;
    private String month;
    private boolean happy = false;

    public Date()
    {

    }
    public Date(int departure_day,int arrival_day, String m, int y)
    {
        this.departure_day = departure_day;
        this.arrival_day = arrival_day;
        this.month = m;
        this.year = y;
    }

    public int getDeparture_day() {
        return departure_day;
    }
    public int getArrival_day()
    {
        return arrival_day;
    }


    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString () {
        return "Departure Day: " + this.departure_day + " Arrival Day: " + this.arrival_day + " Month: " + this.month + " Year: " + this.year;
    }

    public boolean isHappy() {
        return happy;
    }
}
