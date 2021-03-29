package com.company.objects;

public class Ticket {

    private String ID;
    private Flight flight;
    private Client client;

    public Ticket(){}

    public Ticket(String ID, Flight f, Client c) {
        this.ID = ID;
        this.flight =f;
        this.client = c;
    }

    public String getID() {
        return ID;
    }

    public Flight getFlight() {
        return flight;
    }

    public Client getClient() {
        return client;
    }

    public String toString() {
        return this.ID + " " + this.client + " " + this.flight;
    }
}
