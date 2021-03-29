package com.company.objects;
import com.company.objects.Airplane;

import java.util.ArrayList;

public class Airport {

    private String name;
    private String city;
    private String country;
    private String ID;
    private double latitude;
    private double longitude;
    private boolean happy = false;

    //private ArrayList<Airplane> airplaneList = new ArrayList<Airplane>();

    public Airport(String name, String city, String country, String ID,double latitude,double longitude) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.ID = ID;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /*public void addAirplane(Airplane a) {
        airplaneList.add(a);
    }*/

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getID() {
        return ID;
    }

    public double getLatitude()
    {
        return this.latitude;
    }
    public double getLongitude()
    {
        return this.longitude;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + this.name + '\'' +
                ", city='" + this.city + '\'' +
                ", country='" + this.country + '\'' +
                ", ID='" + ID + '\'' +
                ", latitude=" + this.latitude +
                ", longitude=" + this.longitude +
                '}';
    }

    public boolean isHappy() {
        return happy;
    }

    /*public ArrayList<Airplane> getAirplaneList() {
        return airplaneList;
    }*/
    
}
