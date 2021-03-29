package com.company.objects;

public class Client {

    private String name;
    private String surname;
    private String ID;
    private boolean happy = false;

    public Client()
    {

    }
    public Client(String n, String s, String ID) {
        this.name = n;
        this.surname = s;
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String toString() {
        return "name: " + this.name + " Surname: " + this.surname + " ID: " + this.ID;
    }

    public boolean isHappy() {
        return happy;
    }
}
