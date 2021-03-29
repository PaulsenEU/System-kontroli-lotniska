package com.company.Service;
import com.company.objects.*;
import java.util.ArrayList;
import java.io.*;

import com.company.objects.Airplane;

import javax.swing.*;

public class FlightService implements Service {
    private ArrayList<Flight> listOfFlights = new ArrayList<Flight>();

    public void addFlight(Flight f) {
        listOfFlights.add(f);
    }



    public String getFlightByID(String ID) {
        for(int i = 0; i < listOfFlights.size(); i++) {
            if(listOfFlights.get(i).getID().equals(ID)) return listOfFlights.get(i).toString();
        }
        return "Nie ma podanej wycieczki na liscie";
    }

    public void GenerateFLight(Route route, AirplaneService AS, String flight_id, Date date, ClientListService cls) {
        Airplane tmp = new Airplane();
        tmp = AS.traverseAirplaneList(route.getDistance());
        if (tmp.isAvailable()) {
            if (cls.listSize() <= tmp.getCapacity()) {
                Flight f = new Flight(flight_id, tmp, route, date);
                AS.setUnavailable(tmp.getPlaneID());
                f.addPassengers(cls);
                this.addFlight(f);
            }
            else
            {
                System.out.println("Nie znaleziono odpowiedniego samolotu");
            }
        }
    }
    public ArrayList<Flight> getListOfFlights() {
        return listOfFlights;
    }

    public void SaveToFile() {
        File filename = new File("FlightListLoad.txt");
        try {
            FileWriter fw = new FileWriter(filename);
            Writer output = new BufferedWriter(fw);
            int sz = listOfFlights.size();
            for (int i = 0; i < sz; i++) {
                output.write(listOfFlights.get(i).getID() +" "+listOfFlights.get(i).getAirplane().getPlaneID() + " "+ listOfFlights.get(i).getRoute().getID() +" "+ listOfFlights.get(i).getDate().getDeparture_day() + " " +listOfFlights.get(i).getDate().getArrival_day()+" "+listOfFlights.get(i).getDate().getMonth() + " "+listOfFlights.get(i).getDate().getYear()+ "\n");

            }
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nie mozna stworzyc pliku");
        }

    }


    public void DisplayListOfFlights()
    {
        for(Flight flight : listOfFlights)
        {
            System.out.println(flight);
        }
    }


    public void remove(String ID) {
        listOfFlights.removeIf(flight -> flight.getID().equals(ID));
    }


}
