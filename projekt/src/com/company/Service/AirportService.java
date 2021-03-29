package com.company.Service;
import com.company.objects.*;

import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

public class AirportService implements Service {
    private ArrayList<Airport> listOfAirports = new ArrayList<Airport>();

    public void addAirport(Airport a) {
        listOfAirports.add(a);
    }

    public void airportByCountry(String country) {
        for (Airport listOfAirport : listOfAirports) {
            if (listOfAirport.getCountry().equals(country))
                System.out.println(listOfAirport);
        }
    }

    public boolean isOnList(String ID) {
        for (Airport listOfAirport : listOfAirports) {
            if (listOfAirport.getID().equals(ID)) {
                return true;
            }

        }
        return false;
    }

    public Airport getAirportId(String ID)
    {
        for(Airport airport : listOfAirports)
        {
            if(airport.getID().equals(ID))
            {
                return airport;
            }
        }
        return null;
    }

    public void remove(String ID) {
        listOfAirports.removeIf(airport -> airport.getID().equals(ID));
    }

    public ArrayList<Airport> getListOfAirports()
    {
        return listOfAirports;
    }

    public void DisplayListOfAirports ()
    {
        for (Airport airport: listOfAirports) {
            System.out.println(airport);
        }
    }


    public void LoadFromFile() throws IOException  {
        BufferedReader reader = new BufferedReader(new FileReader("AirportListLoad.txt"));
        String line = null;
        //StringTokenizer st = new StringTokenizer(line);
        while((line=reader.readLine()) != null)
        {
            String[] airportinfo = line.split(" ");
            String airport_name = airportinfo[0];
            String airport_city = airportinfo[1];
            String airport_country = airportinfo[2];
            String airport_id = airportinfo[3];
            double airport_latitude = Double.parseDouble(airportinfo[4]);
            double airport_longitude = Double.parseDouble(airportinfo[5]);

            listOfAirports.add(new Airport(airport_name,airport_city,airport_country,airport_id,airport_latitude,airport_longitude));
        }

    }

    public void SaveToFile() {
        File filename = new File("AirportListLoad.txt");
        try {
            FileWriter fw = new FileWriter(filename);
            Writer output = new BufferedWriter(fw);
            int sz = listOfAirports.size();
            for (int i = 0; i < sz; i++) {
                output.write(listOfAirports.get(i).getName() + " " +listOfAirports.get(i).getCity()+" "+ listOfAirports.get(i).getCountry()+" "+listOfAirports.get(i).getID()+" "+listOfAirports.get(i).getLatitude()+" "+listOfAirports.get(i).getLongitude()+"\n");
            }
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nie mozna stworzyc pliku");
        }

    }

}

