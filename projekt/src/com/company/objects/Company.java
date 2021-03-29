package com.company.objects;
import com.company.objects.Client;

import java.util.ArrayList;

public class Company {

    private String name;
    private String compID;
    private ArrayList<Client> listOfClients = new ArrayList<Client>();

    public Company(){}

    public Company(String n, String ID) {
        this.name = n;
        this.compID = ID;
    }

    public void addClient(Client c) {
        listOfClients.add(c);
    }

    public void deleteClient(Client c) {
        for(int i = 0; i < listOfClients.size(); i++) {
            if(listOfClients.get(i) == c) {
                listOfClients.remove(i);
                break;
            }
        }
    }

    public Client GetClient(String ID)
    {
        for(Client client: listOfClients)
        {
            if(client.getID().equals(ID))
            {
                return client;
            }
        }
        return null;
    }
    public void DisplayCompanyClientsList()
    {
        for(Client client: listOfClients)
        {
            System.out.println(client);
        }
    }

    public ArrayList<Client> getListOfClients() {
        return listOfClients;
    }

    public String getName() {
        return this.name;
    }

    public String getCompID() {
        return this.compID;
    }

    public String toString() {
        return  "Biuro turystyczne: " + this.name;
    }
}
