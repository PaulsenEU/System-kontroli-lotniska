package com.company.objects;
import com.company.Service.ClientListService;
import java.util.ArrayList;

public class Flight {

    private String ID;
    private Airplane airplane;
    private Route route;
    private ArrayList<Client> passengerList = new ArrayList<Client>();
    private Date date;

    public Flight(String ID, Airplane a, Route r, Date d) {
        this.ID = ID;
        this.airplane = a;
        this.route = r;
        this.date = d;
    }

    public void addPassengers(ClientListService cls)
    {
        passengerList.addAll(cls.getListOfClients());
    }


    public String getID() {
        return ID;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Route getRoute() {
        return route;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Client> getPassengerList() {
        return passengerList;
    }

    public String toString() {
        return "Wycieczka nr: " + this.ID;
    }
}
