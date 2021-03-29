package com.company.objects;

public class Airplane {

    private String planeID;
    private int capacity;
    private double range;
    public boolean isAvailable = true;
    private boolean happy = false;

    public Airplane()
    {

    }

    public Airplane(String ID, int c, double r) {
        this.planeID = ID;
        this.capacity = c;
        this.range = r;
    }

    public double getRange() {
        return this.range;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String toString() {
        return "Samolot: " + "ID: " + this.planeID + " " + "capacity: " + " " + this.capacity + " " + "range: " + this.range;
    }

    public String getPlaneID() {
        return planeID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isHappy() {
        return happy;
    }
}
