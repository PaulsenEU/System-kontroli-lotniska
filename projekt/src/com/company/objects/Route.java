package com.company.objects;

public class Route {
    private Airport from_id;
    private Airport to_id;
    private double distance;
    private String ID;
    private boolean happy = false;
    public Route()
    {

    }

    public Route(Airport from,Airport to, double distance, String ID) {
        this.from_id = from;
        this.to_id = to;
        this.distance = distance;
        this.ID = ID;
    }

    public double getDistance() {
        return this.distance;
    }


    public String getID() {
        return this.ID;
    }

    public Airport getFromID()
    {
        return this.from_id;
    }
    public Airport getToID()
    {
        return this.to_id;
    }

    public boolean isHappy() {
        return happy;
    }

}
